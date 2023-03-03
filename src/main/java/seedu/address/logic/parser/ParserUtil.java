package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.drug.*;
import seedu.address.model.person.*;
import seedu.address.model.person.patient.*;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    public static DateOfBirth parseDateOfBirth(String birthDate) throws ParseException {
        requireNonNull(birthDate);
        String trimmedBirthDate = birthDate.trim();
        if (!DateOfBirth.isValidBirthDate(trimmedBirthDate)) {
            throw new ParseException(DateOfBirth.MESSAGE_CONSTRAINTS);
        }
        return new DateOfBirth(trimmedBirthDate);
    }

    public static Gender parseGender(String gender) throws ParseException {
        requireNonNull(gender);
        String trimmedGender = gender.trim();
        if (!Gender.isValidGender(trimmedGender)) {
            throw new ParseException(Gender.MESSAGE_CONSTRAINTS);
        }
        return new Gender(trimmedGender);
    }

    public static Ic parseIc(String icNumber) throws ParseException {
        requireNonNull(icNumber);
        String trimmedIcNumber = icNumber.trim();
        if (!Ic.isValidIc(trimmedIcNumber)) {
            throw new ParseException(Ic.MESSAGE_CONSTRAINTS);
        }
        return new Ic(trimmedIcNumber);
    }

    public static DrugAllergy parseDrugAllergy(String drugAllergy) throws ParseException {
        requireNonNull(drugAllergy);
        String trimmedDrugAllergy = drugAllergy.trim();
        if (!DrugAllergy.isValidDrugAllergy(trimmedDrugAllergy)) {
            throw new ParseException(DrugAllergy.MESSAGE_CONSTRAINTS);
        }
        return new DrugAllergy(trimmedDrugAllergy);
    }

    public static EmergencyContact parseEmergencyContact(Person emergencyContactPerson,
                                                         String emergencyContactRelationship) {
        requireNonNull(emergencyContactPerson, emergencyContactRelationship);

        //TODO: checker for relationship?
        String trimmedEmergencyContactRelationship = emergencyContactRelationship.trim();
        return new EmergencyContact(emergencyContactPerson, trimmedEmergencyContactRelationship);
    }
    /**
     * Parses a {@code String tradeName} into a {@code TradeName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tradeName} is invalid.
     */
    public static TradeName parseTradeName(String tradeName) throws ParseException {
        requireNonNull(tradeName);
        String trimmedTradeName = tradeName.trim();
        if (!TradeName.isValidTradeName(trimmedTradeName)) {
            throw new ParseException(TradeName.MESSAGE_CONSTRAINTS);
        }
        return new TradeName(trimmedTradeName);
    }

    /**
     * Parses a {@code String ingredient} into a {@code ActiveIngredient}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code ingredient} is invalid.
     */
    public static ActiveIngredient parseActiveIngredient(String ingredient) throws ParseException {
        requireNonNull(ingredient);
        String trimmedIngredient = ingredient.trim();
        if (!ActiveIngredient.isValidIngredient(trimmedIngredient)) {
            throw new ParseException(ActiveIngredient.MESSAGE_CONSTRAINTS);
        }
        return new ActiveIngredient(trimmedIngredient);
    }

    /**
     * Parses a {@code String direction} into a {@code Direction}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code direction} is invalid.
     */
    public static Direction parseDirection(String direction) throws ParseException {
        requireNonNull(direction);
        String trimmedDirection = direction.trim();
        if (!Direction.isValidDirection(trimmedDirection)) {
            throw new ParseException(Direction.MESSAGE_CONSTRAINTS);
        }
        return new Direction(trimmedDirection);
    }

    /**
     * Parses a {@code String expiryDate} into a {@code ExpiryDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code expiryDate} is invalid.
     */
    public static ExpiryDate parseExpiryDate(String expiryDate) throws ParseException {
        requireNonNull(expiryDate);
        String trimmedExpiryDate = expiryDate.trim();
        if (!ExpiryDate.isValidExpiryDate(trimmedExpiryDate)) {
            throw new ParseException(ExpiryDate.MESSAGE_CONSTRAINTS);
        }
        return new ExpiryDate(trimmedExpiryDate);
    }

    /**
     * Parses a {@code String purpose} into a {@code Purpose}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code purpose} is invalid.
     */
    public static Purpose parsePurpose(String purpose) throws ParseException {
        requireNonNull(purpose);
        String trimmedPurpose = purpose.trim();
        if (!Purpose.isValidPurpose(trimmedPurpose)) {
            throw new ParseException(Purpose.MESSAGE_CONSTRAINTS);
        }
        return new Purpose(trimmedPurpose);
    }

    /**
     * Parses a {@code String sideEffect} into a {@code SideEffect}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code sideEffect} is invalid.
     */
    public static SideEffect parseSideEffect(String sideEffect) throws ParseException {
        requireNonNull(sideEffect);
        String trimmedSideEffect = sideEffect.trim();
        if (!SideEffect.isValidSideEffect(trimmedSideEffect)) {
            throw new ParseException(SideEffect.MESSAGE_CONSTRAINTS);
        }
        return new SideEffect(trimmedSideEffect);
    }

    /**
     * Parses a {@code String count} into a {@code StorageCount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code count} is invalid.
     */
    public static StorageCount parseStorageCount(String count) throws ParseException {
        requireNonNull(count);
        String trimmedCount = count.trim();
        if (!StorageCount.isValidStorageCount(trimmedCount)) {
            throw new ParseException(StorageCount.MESSAGE_CONSTRAINTS);
        }
        return new StorageCount(trimmedCount);
    }

}
