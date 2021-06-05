package TOP100;

/**
 * @author xushu
 * @create 5/22/21 7:48 PM
 * @desc
 */
public class Q55_CanJump {

    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxStep){
                return false;
            }
            maxStep = Math.max(maxStep, i + nums[i]);
        }

        return true;
    }
}
