package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Dormitory {
    private int dormitoryId;
    private int score;

    public Dormitory() {
        super();
    }

    public Dormitory(int dormitoryId, int score) {
        this.dormitoryId = dormitoryId;
        this.score = score;
    }

    public int getDormitoryId() {
        return dormitoryId;
    }


    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Dormitory{" + "dormitoryId=" + dormitoryId + ", score=" + score + '}';
    }
}
