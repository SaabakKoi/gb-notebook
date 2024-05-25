package notebook.util;

public class UserValidator {

     public String isNameValid(String name){
         if(name.isEmpty()){
             throw new RuntimeException("No data found");
         }
         return name.trim().replaceAll(" ", "");
     }
}
