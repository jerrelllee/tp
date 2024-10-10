package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRESENT;

import java.time.LocalDate;

import seedu.address.logic.commands.MarkAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Attendance;


/**
 * Parses input arguments and creates a new MarkAttendanceCommand object
 */
public class MarkAttendanceCommandParser implements Parser<MarkAttendanceCommand> {


    @Override
    public MarkAttendanceCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                CliSyntax.PREFIX_NAME,
                CliSyntax.PREFIX_DATE,
                CliSyntax.PREFIX_PRESENT
        );

        // Retrieve the name value
        String nameStr = argMultimap.getValue(CliSyntax.PREFIX_NAME).orElseThrow(() ->
                new ParseException("Name cannot be empty."));
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        LocalDate date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        Attendance attendance = ParserUtil.parseAttendance(argMultimap.getValue(PREFIX_PRESENT).get());


        return new MarkAttendanceCommand(name, date, attendance);
    }
}
