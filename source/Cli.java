import org.apache.commons.cli.*;

public class Cli {
    private String[] args = null;
    private Options options = new Options();

    public Cli(String[] args) {
        this.args = args;
        options.addOption("l", "line", false, "Show Line count");
        options.addOption("w", "word", false, "Show Word count");
        options.addOption("c", "byte", false, "Show Character count");
        options.addOption("h", "help", false, "Show help");
    }

    public CommandLine parse() throws ParseException {
        CommandLineParser parser = new BasicParser();
        CommandLine cmd = parser.parse(options, args);
        return cmd;
    }

    public void printHelp() {
        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Wc", options);
    }
}
