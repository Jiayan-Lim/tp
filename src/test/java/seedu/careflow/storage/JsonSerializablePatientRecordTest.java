package seedu.careflow.storage;

import org.junit.jupiter.api.Test;
import seedu.careflow.commons.exceptions.IllegalValueException;
import seedu.careflow.commons.util.JsonUtil;
import seedu.careflow.model.PatientRecord;
import seedu.careflow.testutil.TypicalPatients;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.careflow.testutil.Assert.assertThrows;

class JsonSerializablePatientRecordTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializablePatientRecordTest");
    private static final Path TYPICAL_PATIENTS_FILE = TEST_DATA_FOLDER.resolve("typicalPatientsPatientRecord.json");
    private static final Path INVALID_PATIENT_FILE = TEST_DATA_FOLDER.resolve("invalidPatientPatientRecord.json");
    private static final Path DUPLICATE_PATIENT_FILE = TEST_DATA_FOLDER.resolve("duplicatePatientPatientRecord.json");

    @Test
    public void toModelType_typicalPatientFile_success() throws Exception {
        JsonSerializablePatientRecord dataFromFile = JsonUtil.readJsonFile(TYPICAL_PATIENTS_FILE,
                JsonSerializablePatientRecord.class).get();
        PatientRecord patientRecordFromFile = dataFromFile.toModelType();
        PatientRecord typicalPatientsPatientRecord = TypicalPatients.getTypicalPatientRecord();
        assertEquals(patientRecordFromFile, typicalPatientsPatientRecord);
    }
    @Test
    public void toModelType_invalidPatientFile_throwsIllegalValueException() throws Exception {
        JsonSerializablePatientRecord dataFromFile = JsonUtil.readJsonFile(INVALID_PATIENT_FILE,
                JsonSerializablePatientRecord.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }
    @Test
    public void toModelType_duplicatePatients_throwsIllegalValueException() throws Exception {
        JsonSerializablePatientRecord dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PATIENT_FILE,
                JsonSerializablePatientRecord.class).get();
        assertThrows(IllegalValueException.class, JsonSerializablePatientRecord.MESSAGE_DUPLICATE_PATIENT,
                dataFromFile::toModelType);
    }
}