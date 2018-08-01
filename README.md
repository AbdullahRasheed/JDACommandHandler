# JDACommandHandler
Easy to use Command Handler for the Java Discord Bot API JDA

`Command Methods`

| Method  | Description |
| ------------- | ------------- |
| `setDesription(String description)`  | Sets the Command's description (Can be used for future reference)  |
| `setUsage(String usage)`  | Sets the Command's usage (Can be used for future reference)  |
| `setRequiredArgs(int requiredArgs)`  | Sets the minimum arguments allowed for the Command  |
| `setRequiredPermissions(Permission... permissions)`  | Sets the permissions required to execute the command  |
| `setCommandExecuteListener(CommandExecuteListener cmdExecuteListener)`  | Sets the CommandExecuteListener for the command (Allows you to execute code when the command is executed)  |
| `setUsableChannels(TextChannel... usableChannels)`  | Sets the channels that can be used to execute the command  |
| `register()`  | Registers the command so it can be used  |
