package example_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eternalteach
 * @since 2021/10/26 9:46 오후 START - 11:08 오후 END
 */
public class OpenChattingRoom {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChattingRoom a = new OpenChattingRoom();
        a.solution(record);
    }
    public static Map<String, User> userMap = new HashMap<>();
    public static List<UserAction> actionList = new ArrayList<>();

    public String[] solution(String[] record) {

        for(String line : record){
            setUserAction(line);
        }
        int actionSize = actionList.size();
        String[] answer = new String[actionSize];
        for(int i = 0; i < actionSize; i ++){
            UserAction userAction = actionList.get(i);
            switch (userAction.getAction()){
                case "Enter" :
                    answer[i] = userAction.getUser().getNickName() + "님이 들어왔습니다.";
                    break;
                case "Leave" :
                    answer[i] =  userAction.getUser().getNickName() + "님이 나갔습니다.";
                    break;
            }
        }
        return answer;
    }
    public void setUserAction(String line) {
        String[] splitLine = line.split(" ");
        User getUser = userMap.get(splitLine[1]);

        if(getUser == null){
            getUser = new User(splitLine[1], splitLine[2]);
            userMap.put(splitLine[1], getUser);
        } else if(splitLine[0].equals("Enter")){
            getUser.setNickName(splitLine[2]);
        }

        if(splitLine[0].equals("Change")){
            getUser.setNickName(splitLine[2]);
        } else {
            actionList.add(new UserAction(splitLine[0], getUser));
        }
    }

    class UserAction {
        String action;
        User user;

        public UserAction(String action, User user) {
            this.action = action;
            this.user = user;
        }

        public String getAction(){
            return action;
        }

        public User getUser(){
            return user;
        }
    }

    class User {
        private String id;
        private String nickName;

        public User(String id, String nickName){
            this.id = id;
            this.nickName = nickName;
        }

        public String getId() {
            return id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName){
            this.nickName = nickName;
        }
    }
}
