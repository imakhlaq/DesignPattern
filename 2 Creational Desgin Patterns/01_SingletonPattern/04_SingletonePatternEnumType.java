// this will always have single instance
enum SingletonEnum {
    Instance;

    public void debbug(String data) {
        System.out.println(data);
    }
}

class MainEnum {
    public static void main(String[] args) {
        SingletonEnum.Instance.debbug("some data");
    }

}