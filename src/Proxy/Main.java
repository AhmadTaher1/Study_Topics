package Proxy;

/*
بنحط بلايس هولدر مكان الصورة عقبال ما السرفر يروح يجيب الصورة الحقيقية
cons:
code could be more complicated
delay in response as client may not notice that its a remote object in remote proxy




 */

interface Internet{
    public void grantInternetAccess(Employee employee);
}



class RealInternetConnection implements Internet{

    @Override
    public void grantInternetAccess(Employee employee) {
        System.out.println("entered the RealInternetConnection class ");
        System.out.println("Granted internet permission for "+employee.getName());
    }
}

/*
هنا البروكسي واخد دور السكرتيرة اللى هو بيشوف مين الريكويست بتاعه يستحق يوصل للريل اوبجكت و اللي بيكلمها فاكر انه بيتعامل مع المدير نفسه
ممكن البروكسي ياخد دور تاني زي انه ياخد دور البودي جارد بالنسبة للمدير او حتى البريد بحيث يوصله الطلبات وهو مش موجود اصلا
 */

class ProxyInternet implements Internet{

    @Override
    public void grantInternetAccess(Employee employee) {
            if(employee.getSecurityLevel()>5){
                new RealInternetConnection().grantInternetAccess(employee);
            }
            else{
                System.out.println("permission denied");
            }
    }
}



class Employee{
    private int securityLevel;
    private String name;

    public Employee(int securityLevel, String name) {
        this.securityLevel = securityLevel;
        this.name = name;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public String getName() {
        return name;
    }
}




public class Main {

    public static void main(String[] args) {
        Employee e=new Employee(4,"taher");
        ProxyInternet access=new ProxyInternet();
        access.grantInternetAccess(e);
    }
}
