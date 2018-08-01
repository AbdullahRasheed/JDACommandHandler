# JDACommandHandler
Easy to use Command Handler for the Java Discord Bot API JDA

### Command Methods

| Method  | Description |
| ------------- | ------------- |
| `setDesription(String description)`  | Sets the Command's description (Can be used for future reference)  |
| `setUsage(String usage)`  | Sets the Command's usage (Can be used for future reference)  |
| `setRequiredArgs(int requiredArgs)`  | Sets the minimum arguments allowed for the Command (Defaults to 0)  |
| `setRequiredPermissions(Permission... permissions)`  | Sets the permissions required to execute the command (Defaults to usable by anyone)  |
| `setCommandExecuteListener(CommandExecuteListener cmdExecuteListener)`  | Sets the CommandExecuteListener for the command (Allows you to execute code when the command is executed)  |
| `setUsableChannels(TextChannel... usableChannels)`  | Sets the channels that can be used to execute the command (Defaults to all channels)  |
| `register()`  | Registers the command so it can be used  |

### CommandHandler Methods

| Method  | Description |
| ------------- | ------------- |
| `registerCommands(Command... command)`  | Registers multiple commands at once  |
| `getCommands()`  | Returns a list of all the registered commands  |
| `setIncorrectUsageEmbed(IncorrectUsageEmbed incorrectUsageEmbed)`  | Sets a customizable Embed to send when any command does not meet the command's minimum arguments requirement  |
| `setPrefix(String prefix)`  | Sets the prefix used for all commands  |
| `setIncorrectChannelMessage(Message incorrectChannel)`  | Sets the message to send when a command is executed in a channel that the command does not have on its whitelist  |
| `setInsufficientPermissionsMessage(Message insufficientPermissions)`  | Sets the message to send when a member does not meet the required permissions for the command they are trying to execute  |

#### CommandExecuteListener

```java
/**
* Runs when the specified command is run
* @param sender The member who executed the command
* @param channel The channel the command was sent in
* @param args A string array of each word in the command except the command itself
* @param message The message of the command
*/
void onCommand(Member sender, TextChannel channel, String[] args, Message message);
```

#### IncorrectUsageEmbed

```java
/**
* The embed to send when a command is incorrectly used
* @param usage The correct usage of the command
* @param sender The member that executed the command
* @return The Embed to send when a command does not meet the argument requirements
*/
EmbedBuilder getIncorrectEmbed(String usage, Member sender);
```
