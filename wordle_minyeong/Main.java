package wordle_minyeong;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        int cnt=6;
        Scanner sc=new Scanner(System.in);
        Random random=new Random();

        WordGenerate word=new WordGenerate();
        ArrayList<Character> RandomWord=word.getWord();
        System.out.println(RandomWord);


        String guess;
        LocalDate ld=LocalDate.now();
        System.out.println("wordle 게임을 시작합니다.");

        while (0<cnt){
            LocalDate ld2=LocalDate.now();
            if(!ld.equals(ld2)) {
                ld=ld2;
                cnt = 6;
            }



            System.out.println();
            System.out.println("기회:"+cnt);

            System.out.print("대문자 네글자를 입력하세요:");
            guess=sc.nextLine();


            int ball=0;
            int strike=0;

            char[] guessArray=guess.toCharArray();
            for(int i=0;i<4;i++){
                if(RandomWord.get(i) ==guessArray[i]){
                    strike+=1;
                } else if (RandomWord.contains(guessArray[i])) {
                    ball+=1;
                }
            }

            if (ball==0 && strike==0) {
                System.out.println("낫싱");
            } else if (strike==4) {
                System.out.println("4스트라이크\n" +
                        "단어를 맞히셨습니다! 게임 종료");
                break;
            } else{
                System.out.print(ball+"볼 "+strike+"스트라이크\n");
            }
            if (cnt==1){
                System.out.print("6번의 기회를 모두 사용하셨습니다! 게임 종료");
                break;
            }
            cnt-=1;


        }

    }}