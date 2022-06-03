package programmers.level2;

/*
    문제    : 프로그래머스 오픈채팅방
    유형    :
	난이도   : Easy (Level 2)
	시간    : 20m
	uri    : https://programmers.co.kr/learn/courses/30/lessons/42888
    날짜    : 22.05.07(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Programmers42888 {

    static final int COMMAND = 0;
    static final int ID = 1;
    static final int NICK_NAME = 2;
    static final String ENTER_MESSAGE = "들어왔습니다.";
    static final String LEAVE_MESSAGE = "나갔습니다.";
    static final HashMap<String, String> userMap = new HashMap<>();

    static class Log {

        String uid;
        String message;

        public Log(String uid, String message) {
            this.uid = uid;
            this.message = message;
        }

        @Override
        public String toString() {
            return userMap.get(uid) + "님이 " + message;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<Log> logs = new ArrayList<>(record.length);
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[COMMAND].equals("Enter")) {
                userMap.put(split[ID], split[NICK_NAME]);
                logs.add(new Log(split[ID], ENTER_MESSAGE));
            } else if (split[COMMAND].equals("Leave")) {
                logs.add(new Log(split[ID], LEAVE_MESSAGE));
            } else {
                userMap.put(split[ID], split[NICK_NAME]);
            }
        }
        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            answer[i] = logs.get(i).toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers42888 sol = new Programmers42888();
        String[] record = new String[]{
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(sol.solution(record)));
    }
}
