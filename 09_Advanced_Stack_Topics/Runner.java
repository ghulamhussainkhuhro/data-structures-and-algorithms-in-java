package VIP_Stack;

public class Runner {
    public static void main(String[] args) {
        VIPStack stack = new VIPStack(10);
        
        
        
        stack.push("Abbas Ali", true);
        stack.push("Ghulam Hussain", false);
        stack.push("Alimeer", true);
        stack.push("Sarmad", false);
        
        
        stack.display();

        
        stack.popVip();
        
        System.out.println();
        System.out.println("Stack after popping VIPs:");
        stack.display();
    }
}

