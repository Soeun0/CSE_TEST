/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cse_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jasuj
 */



public class UserManagement {
    private String username;
    
    static IOProcessor tool = IOProcessor.getInstance();
    
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> Id = new ArrayList<>();
    ArrayList<String> Pw = new ArrayList<>();
    ArrayList<Boolean> IsManager = new ArrayList<>();
    
    String CurrentUserName;
    String CurrentUserId;
    String CurrentUserPw;
    String CurrentUserType;
    
    String[] temp = new String[30];
    
     private static final UserManagement instance = new UserManagement();
    
        private UserManagement(){    //처음 생성될때 유저데이터를 파일에서 불러와 저장
        
        ArrayList<String[]> UserTemp = new ArrayList<>(tool.getTextedData("UserData.txt"));

        for(int i=0; i<UserTemp.size();i++){
            Name.add(UserTemp.get(i)[0]);
            Id.add(UserTemp.get(i)[1]);
            Pw.add(UserTemp.get(i)[2]);
            if(UserTemp.get(i)[3].equals("true")){
                IsManager.add(true);
            } else {
                 IsManager.add(false);
            }
        }
        }
        
        
        public static UserManagement getInstance(){
            return instance;
        }
        
        
        public void InspectUserList(){ //사용자 목록 출력
           
        for(int i=0;i<Name.size();i++){
             System.out.println(
             i+1
               +
             "."        
               +
             String.format("%15s",Name.get(i))
               +
             String.format("%15s",Id.get(i))
               +
             String.format("%15s",Pw.get(i))
               +
             String.format("%15b",IsManager.get(i))
            
             );
            
          }
            
        }
        
    
        
        public void AddUser(){ //사용자정보 등록
           InspectUserList();

           System.out.println("이름: ");
           temp[0] = tool.getUserInput();
           System.out.println("아이디: ");
           temp[1] = tool.getUserInput();
           System.out.println("비밀번호: ");
           temp[2] = tool.getUserInput();
           System.out.println("관리자 여부(true or false): ");
           temp[3] = tool.getUserInput();
           
           Name.add(temp[0]);
           Id.add(temp[1]);
           Pw.add(temp[2]);
           IsManager.add(Boolean.parseBoolean(temp[3]));
           
           Regenerate("UserData");
           
           InspectUserList();
        }
        
        public void DeleteUser(){ //사용자정보 삭제
            InspectUserList();
            
            System.out.println("삭제할 대상의 번호를 입력하세요: ");
           
            String input = tool.getUserInput();
            
            int selNum = Integer.parseInt(input)-1;
            
            Name.remove(selNum);
            Id.remove(selNum);
            Pw.remove(selNum);
            IsManager.remove(selNum);
            
             Regenerate("UserData");
            
            InspectUserList();
        }
        
        public void ModifyUser(){ //사용자정보 수정
           
        }
        
        
                            
        public void Regenerate(String str){ //변경된 파일을 백업 후 재성성
            tool.BackUpTextFile("./"+str+".txt");
       
        try{
             File f = new File("./UserData.txt");
        if(f.exists()){
            System.out.println("파일이 이미 존재합니다."); 
        }else if(f.createNewFile()){
             System.out.println("파일을 생성합니다.");
        }
        } catch (IOException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
        try(FileOutputStream output = new FileOutputStream("./"+str+".txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter out=new BufferedWriter(writer); )
        {
            for(int i=0;i<Name.size();i++){ //이름,아이디,비밀번호,관리자여부 형식으로 저장
                 out.append(
                 Name.get(i)
                 +
                 ","        
                 +         
                 Id.get(i)
                 +
                 ","        
                 +      
                 Pw.get(i)
                 +
                 ","        
                 +     
                 String.valueOf(IsManager.get(i))
                 +
                 "/"                      // '/'문자로 사용자와 다른 사용자의 정보를 구분지음
                 );
                 out.append("\n");
            }
            out.append("*");          //시스템에 저장된 사용자데이터의 끝을 나타냄
           
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
        
        
        
        
        }
    
    
        
 

}
