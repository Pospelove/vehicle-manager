package commands;

public interface Command {

    /**
     * the main method of the class, doing whatever that needs to be done
     * @return String instruction of what the output system should show
     */
    public String execute();

    /**
     * String information about command
     */
    public String getDescription();

    /**
     * transforms commands.CommandFooBar to "foo_bar"
     */
    default String getName() {
        int idx = ("Command").length();
        String fullClassName = this.getClass().getName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);

        String commandNameCamelCase = className.substring(idx);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < commandNameCamelCase.length(); ++i) {
            String character = commandNameCamelCase.substring(i, i + 1);
            boolean isLowerCase = character.toLowerCase().equals(character);
            if (isLowerCase) {
                res.append(character);
            } else {
                if (i > 0) {
                    res.append("_");
                }
                res.append(character.toLowerCase());
            }
        }
        return res.toString();
    }
}
