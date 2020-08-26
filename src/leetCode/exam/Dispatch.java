package leetCode.exam;

public class Dispatch {
    static class QQ {}
    static class _360 extends QQ {}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg){
            System.out.println("father choose 360");
        }

        public void onlyFatherHas(){
            System.out.println("father has only");
        }
    }

    public static class Son extends Father{
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg){
            super.onlyFatherHas();
            System.out.println("son choose 360");
        }
    }

    private static void choice(Father father,QQ arg){
        father.hardChoice(arg);
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new QQ());
        son.hardChoice(new QQ());
        choice(son,new _360());
        father.onlyFatherHas();
    }

}
