package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.CareFlowModel;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";


//    @Override
//    public CommandResult execute(Model model) {
//        requireNonNull(model);
//        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
//        return new CommandResult(MESSAGE_SUCCESS);
//    }

    @Override
    public CommandResult execute(CareFlowModel model) throws CommandException {
        return null;
    }
}
