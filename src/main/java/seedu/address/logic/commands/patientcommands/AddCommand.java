package seedu.address.logic.commands.patientcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.CareFlowModel;
import seedu.address.model.person.Patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Adds a patient to the patient records
 */
public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a patient to patient records. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + PREFIX_DOB + "DOB "
            + PREFIX_GENDER + "GENDER "
            + PREFIX_IC + "IC"
            + PREFIX_DRUG_ALLERGY + "DRUG ALLERGY "
            + PREFIX_EMERGENCY_CONTACT_NUMBER + "EMERGENCY CONTACT NUMBER\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Tom Smith "
            + PREFIX_PHONE + "84356788 "
            + PREFIX_EMAIL + "tsmith@gmail.com "
            + PREFIX_ADDRESS + "969 Lock Street #04-32 "
            + PREFIX_DOB + "2001-05-28 "
            + PREFIX_GENDER + "MALE "
            + PREFIX_IC + "T0278234M "
            + PREFIX_DRUG_ALLERGY + "Aspirin "
            + PREFIX_EMERGENCY_CONTACT_NUMBER + "93746552\n";


    public static final String MESSAGE_SUCCESS = "New patient added: %1$s";
    public static final String MESSAGE_DUPLICATE_PATIENT = "This patient already exists.";
    private final Patient patientToAdd;

    public AddCommand(Patient patient) {
        requireNonNull(patient);
        patientToAdd = patient;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof AddCommand
                && patientToAdd.equals(((AddCommand) other).patientToAdd));
    }

    @Override
    public CommandResult execute(CareFlowModel careFlowModel) throws CommandException {
        requireNonNull(careFlowModel);

        if(careFlowModel.hasPatient(patientToAdd)){
            throw new CommandException(MESSAGE_DUPLICATE_PATIENT);
        }

        careFlowModel.addPatient(patientToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, patientToAdd));
    }
}