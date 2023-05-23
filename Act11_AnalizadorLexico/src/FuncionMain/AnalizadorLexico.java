package FuncionMain;

public class AnalizadorLexico 
{
    public static void main( String[] args )
    {
        DomParser dp = new DomParser("https://xmlserver.fly.dev/employees");
        try {
			dp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}