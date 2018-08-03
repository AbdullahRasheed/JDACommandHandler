# JDACommandHandler
Easy to use Command Handler for the Java Discord Bot API JDA

[![button](https://i.imgur.com/9EQfVKM.png)](https://github.com/DeDose1/JDACommandHandler/releases)

**Tutorial Video** https://www.youtube.com/watch?v=fDDtC3AiGVc

### Command Methods

| Method  | Description |
| ------------- | ------------- |
| `setDesription(String description)`  | Sets the Command's description (Can be used for future reference)  |
| `setUsage(String usage)`  | Sets the Command's usage (Can be used for future reference)  |
| `setRequiredArgs(int requiredArgs)`  | Sets the minimum arguments allowed for the Command (Defaults to 0)  |
| `setRequiredPermissions(Permission... permissions)`  | Sets the permissions required to execute the command (Defaults to usable by anyone)  |
| `setCommandExecuteListener(CommandExecuteListener cmdExecuteListener)`  | Sets the CommandExecuteListener for the command (Allows you to execute code when the command is executed)  |
| `setUsableChannels(TextChannel... usableChannels)`  | Sets the channels that can be used to execute the command (Defaults to all channels)  |
| `setUsableChannels(Guild guild, String... channelNames)`  | Sets the channels that can be used to execute the command (Defaults to all channels)  |
| `getAliases()`  | Returns the aliasesof the Command  |
| `getDescription()`  | Returns the Description of the command (Will default to "No description defined" if a description has not been set)  |
| `getUsage()`  | Returns the Usage of the command (Will default to "No Usage defined" if a usage has not been set  |
| `getRequiredArgs()`  | Returns the minimum required arguments of the Command  |
| `getUsableChannels()`  | Returns a list of the usable channels for the Command (If the List is empty, then it allows the command in every channel)  |
| `getRequiredPermissions()`  | Returns a list of the required permissions to execute the command  |
| `getCommandExecuteListener()`  | Returns the CommandExecuteListener for the Command  |

### CommandHandler Methods

| Method  | Description |
| ------------- | ------------- |
| `registerCommands(Command... command)`  | Registers multiple commands at once  |
| `getCommands()`  | Returns a list of all the registered commands  |
| `setIncorrectUsageEmbed(IncorrectUsageEmbed incorrectUsageEmbed)`  | Sets a customizable Embed to send when any command does not meet the command's minimum arguments requirement  |
| `setPrefix(String prefix)`  | Sets the prefix used for all commands  |
| `setIncorrectChannelMessage(Message incorrectChannel)`  | Sets the message to send when a command is executed in a channel that the command does not have on its whitelist  |
| `setInsufficientPermissionsMessage(Message insufficientPermissions)`  | Sets the message to send when a member does not meet the required permissions for the command they are trying to execute  |
| `getPrefix()`  | Gets the prefix used for all commands  |
| `getIncorrectUsageEmbed()`  | Gets the embed that is sent when a command is executed with not enough arguments  |
| `getInsufficientPermissionsMessage()`  | Gets the message that is sent when a command is executed by a member that does not have the required permissions to execute the command  |
| `getIncorrectChannelMessage()`  | Gets the message that is sent when a command is executed in a channel that the command does not have whitelisted  |

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
