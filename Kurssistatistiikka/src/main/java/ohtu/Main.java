package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        
        

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Information[] infos = mapper.fromJson(bodyText2, Information[].class);
        
        
        System.out.println("Opiskelijanumero " + studentNr);
        System.out.println("");
        
        int tehdytTeht = 0;
        int tunnit = 0;
        List<Integer> teht = new ArrayList();
        for(Information information : infos){           
            if(information.getName().equals("rails2018")){
                System.out.println(information.getFullName() + " " + information.getTerm() + " "+information.getYear());

                for(Submission submission : subs){ 
                    if(submission.getCourse().equals("rails2018")){
                        System.out.println("Viikko " + submission.getWeek() + ":");
                        System.out.println("tehtyjä tehtäviä "+ submission.getExercises()+"/"+information.getMaxTeht(submission.getWeek()) +" aikaa kului "+submission.getHours()+ " tehdyt tehtävät: " +submission.getExerciseList());
                        tehdytTeht = tehdytTeht + submission.getExercises();
                        tunnit = tunnit + submission.getHours();
                        teht = information.getExercises();
                    }
                }    
            }   
        }
            
          int sum = teht.stream().mapToInt(Integer::intValue).sum();
          
          
          System.out.println("Yhteensä: "+ tehdytTeht +"/"+ sum+ " tehtävää "+tunnit+" tuntia");
          System.out.println("");
        
          
          
        int tehdytTeht2 = 0;
        int tunnit2 = 0;
        List<Integer> teht2 = new ArrayList();
        for(Information information : infos){           
            if(information.getName().equals("ohtu2018")){
                System.out.println(information.getFullName() + " " + information.getTerm() + " "+information.getYear());

                for(Submission submission : subs){ 
                    if(submission.getCourse().equals("ohtu2018")){
                        System.out.println("Viikko " + submission.getWeek() + ":");
                        System.out.println("tehtyjä tehtäviä "+ submission.getExercises()+"/"+information.getMaxTeht(submission.getWeek()) +" aikaa kului "+submission.getHours()+ " tehdyt tehtävät: " +submission.getExerciseList());
                        tehdytTeht2 = tehdytTeht2 + submission.getExercises();
                        tunnit2 = tunnit2 + submission.getHours();
                        teht2 = information.getExercises();
                    }
                }    
            }   
        }
            
          int sum2 = teht2.stream().mapToInt(Integer::intValue).sum();
          
          
          System.out.println("Yhteensä: "+ tehdytTeht2 +"/"+ sum2+ " tehtävää "+tunnit2+" tuntia");
//        int teht = 0;
//        int tunnit = 0;
//        for(Submission submission : subs){
//           System.out.println(submission);
//           teht = teht + submission.getExercises();
//           tunnit = tunnit + submission.getHours();
//            
//        }
//        System.out.println("Yhteensä: " +teht+ " tehtävää "+ tunnit+ " tuntia");

    }
}