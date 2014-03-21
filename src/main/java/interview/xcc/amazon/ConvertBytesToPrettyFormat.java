package interview.xcc.amazon;

/**
 * Amazon Online Coding Question
 *
 * 03/18/2014
 *
 * Convert bytes to pretty format
 *
 * input is integer will be less than or equal to 1G
 * max 3 digits
 * no beginning 0s or trailing 0s
 *
 * Created by Maximus on 3/17/14.
 */
public class ConvertBytesToPrettyFormat
{
    private String format(double input)
    {
        // if it i is equal to an int
        if(input == (int) input)
        {
            return String.format("%d", (int) input);
        }
        else if(input > 100)
        {
            //DecimalFormat fmt = new DecimalFormat("###");
            //return fmt.format(input);
            return String.format("%3.0f", input);
        }
        else if(input > 10)
        {
            //DecimalFormat fmt = new DecimalFormat("##.0");
            //String output = fmt.format(input);
            String output = String.format("%3.1f", input);
            if(output.charAt(3) == '0')
            {
                output = output.substring(0, 2);
            }
            return output;
        }
        else
        {
            //DecimalFormat fmt = new DecimalFormat("#.00");
            //String output = fmt.format(input);
            String output = String.format("%3.2f", input);
            if(output.charAt(3) == '0')
            {
                if(output.charAt(2) == '0')
                {
                    output = output.substring(0, 1);
                }
                else
                {
                    output = output.substring(0, 3);
                }
            }
            return output;
        }
    }

    public String convert(int bytes)
    {
        if(1.00003 == 1)
        {
            System.out.println("Equal");
        }

        if(bytes <= 0)
        {
            return "";
        }
        else if(bytes < 1000)
        {
            return bytes + "B";
        }
        else if(bytes < 1000000)
        {
            return format(bytes / 1000.0) + "K";
        }
        else if(bytes < 1000000000)
        {
            return format(bytes / 1000000.0) + "M";
        }
        else
        {
            return "1G";
        }

    }

    public static void main(String[] args)
    {
        ConvertBytesToPrettyFormat cbtpf = new ConvertBytesToPrettyFormat();
        System.out.println(cbtpf.convert(1101));
    }
}
