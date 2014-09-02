package stack;

public class PostCalc
{
    public static boolean isOperator(char op)
    {
        return ((op=='*') || (op =='/') || (op=='+') || (op=='-'));
    }

    public static boolean isOperand(char op)
    {
        return ((op >= '0') && (op <= '9'));
    }

    public static double evaluate(double op1, char operator, double op2 )
    {
        switch( operator)
        {
            case '*': return op1*op2;
            case '/': return op1/op2;
            case '+': return op1+op2;
            case '-': return op1-op2;
        }

        System.out.println("not a valid operator");
        return 0;
    }

    public static void main(String[] asd)
    {
        String s = "23+4*63/-";
        int len = s.length();
        LinkedStack<Double> stack = new LinkedStack<Double>();
        char token;
        Double digit1 = new Double (0), digit2 = new Double (0),ans;
        double num, op1, op2, result;
        for(int j = 0; j < len; j++)
        {
            token = s.charAt(j);
            if( isOperand(token) )
            {
                num = token - '0';
                try{
                    stack.push(new Double(num));
                } catch (Exception e) {} // catch but do nothing
            }
            else if( isOperator(token))
            {
                try{
                    digit2 = stack.top();
                    stack.pop();
                    digit1 = stack.top();
                    stack.pop();
                } catch (Exception e) {}  //catch but do nothing
                op2 = digit2.doubleValue();
                op1 = digit1.doubleValue();
                result = evaluate(op1, token, op2);
                try{
                    stack.push(new Double(result));
                } catch (Exception e) {}  //catch but do nothing
            }
        }
        ans = stack.top();
        stack.pop();
        System.out.println("result is " + ans.doubleValue() );
    }
}
 