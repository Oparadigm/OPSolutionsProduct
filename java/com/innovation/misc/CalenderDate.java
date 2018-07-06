package com.innovation.misc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.innovation.sql.common.CommonSQL;

/**
 * @author haiderm & Rizwan - This class contains the method which returns the current date and the desired future (+ years) / past
 *         (- years) dates in UK and USA formats.
 *
 */

public class CalenderDate
{

	public static String returnCurrentDate (String strLocation)
	{

		Date cDate = new Date ();
		String currentDate = null;
		DateFormat dateFormat = null;

		if (strLocation.toUpperCase ().equals ("UK"))
			dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		else if (strLocation.toUpperCase ().equals ("USA") || strLocation.toUpperCase ().equals ("US"))
			dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
		else
			return "Please choose either UK or  US / USA.";

		currentDate = dateFormat.format (cDate);
		return currentDate;

	}

	public static String returnDesiredDate (String strLocation, int intDays, int intMonths, int intYears)
	{

		Date cDate = new Date ();
		Date dDate;
		String desiredDate = null;
		DateFormat dateFormat = null;
		Calendar getCalender = Calendar.getInstance ();
		getCalender.setTime (cDate);
		getCalender.add (Calendar.DAY_OF_MONTH, intDays);
		getCalender.add (Calendar.MONTH, intMonths);
		getCalender.add (Calendar.YEAR, intYears);
		dDate = getCalender.getTime ();

		if (strLocation.toUpperCase ().equals ("UK"))
			dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		else if (strLocation.toUpperCase ().equals ("USA") || strLocation.toUpperCase ().equals ("US"))
			dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
		else
			return "Please choose either UK or US / USA.";

		desiredDate = dateFormat.format (dDate);
		return desiredDate;

	}

	// This function takes a starting date as 'strStartDate' and number of working days as 'intDays' as parameters. It then returns
	// the future date by counting the number of working days from the starting date and excluding weekends and public holidays.
	// This function is used in Claim MOJ Tests to calculate Due and Deadline dates of diaries/tasks. Due and Deadline dates of
	// tasks do not include public holidays and Weekends
	public static String returnNextDateBasedOnWorkDays (String strEnvironmentName, String strCompany, String strLocation, String strStartDate, int intDays)
			throws Exception
	{

		Date dteNextDate = null;
		String strNextDate = null;
		DateFormat dateFormat = null;
		Calendar getCalender = Calendar.getInstance ();
		String strSQLQuery;
		List<String> lstNonWorkDayCode;
		String strNonWorkDayCode;
		String strSatSunAdded = "No";

		// Setting up the strLocation and date format to be UK or US specific
		if (strLocation.toUpperCase ().equals ("UK"))
		{
			strLocation = "NONWORKINGDAY.PERIOD.REGION.GB";
			dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		}
		else if (strLocation.toUpperCase ().equals ("USA") || strLocation.toUpperCase ().equals ("US"))
		{
			strLocation = "NONWORKINGDAY.PERIOD.REGION.NYC";
			dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
		}
		else
			return "Please choose either UK or US / USA.";

		// Applying date format on strStartDate
		dteNextDate = dateFormat.parse (strStartDate);

		// Setting up date format for the SQL query
		dateFormat = new SimpleDateFormat ("yyyyMMdd");

		// Getting date in "yyyyMMdd" format for SQL query
		strNextDate = dateFormat.format (dteNextDate);

		getCalender.setTime (dteNextDate);

		// This for loop calculates strNextDate for each of intDays
		for (int i = 1; i <= intDays; i++)
		{
			// Get the next date
			getCalender.add (Calendar.DATE, 1);
			strNextDate = dateFormat.format (getCalender.getTime ());

			// do-while keeps on adding an additional day to the date if date is a non
			// working day
			do
			{
				// This code checks in the database if the date is a public holiday then it adds
				// a day to the date
				strSQLQuery = CommonSQL.returnNonWorkingDay (strLocation, strNextDate);
				lstNonWorkDayCode = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
				try
				{
					strNonWorkDayCode = lstNonWorkDayCode.get (0);
				}
				catch (Exception e)
				{
					strNonWorkDayCode = "";
				}

				if (strNonWorkDayCode != "")
				{
					getCalender.add (Calendar.DATE, 1);
					strNextDate = dateFormat.format (getCalender.getTime ());

				}

				// This While adds a day to the date for each of Saturday and Sunday in order to
				// exclude Saturday and Sunday from
				// date calculation
				while (getCalender.get (Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || getCalender.get (Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				{
					getCalender.add (Calendar.DATE, 1);
					strNextDate = dateFormat.format (getCalender.getTime ());
					strSatSunAdded = "Yes";
				}

				// After adding days for Saturday and Sunday we are again checking if the next
				// day is a public holiday
				if (strSatSunAdded.equalsIgnoreCase ("Yes"))
				{
					strSQLQuery = CommonSQL.returnNonWorkingDay (strLocation, strNextDate);
					lstNonWorkDayCode = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
					try
					{
						strNonWorkDayCode = lstNonWorkDayCode.get (0);
					}
					catch (Exception e)
					{
						strNonWorkDayCode = "";
					}

					if (strNonWorkDayCode != "")
					{
						getCalender.add (Calendar.DATE, 1);
						strNextDate = dateFormat.format (getCalender.getTime ());
					}
					strSatSunAdded = "No";
				}

			} while (strNonWorkDayCode != "");

		}

		// Setting up the date format back to UK or US specific
		if (strLocation.toUpperCase ().equals ("NONWORKINGDAY.PERIOD.REGION.GB"))
			dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		else if (strLocation.toUpperCase ().equals ("NONWORKINGDAY.PERIOD.REGION.NYC"))
			dateFormat = new SimpleDateFormat ("MM/dd/yyyy");

		// Changing date format back to UK or US from SQL specific date format
		strNextDate = dateFormat.format (getCalender.getTime ());

		return strNextDate;

	}

	public static String setRandomDate (String strLocation, int intDays, int intMonths, int intYears)
	{

		Date cDate = new Date ();
		Date rDate;
		String randomDate = null;
		DateFormat dateFormat = null;
		Calendar getCalender = Calendar.getInstance ();
		getCalender.setTime (cDate);
		getCalender.set (Calendar.DAY_OF_MONTH, intDays);
		getCalender.set (Calendar.MONTH, intMonths);
		getCalender.set (Calendar.YEAR, intYears);
		rDate = getCalender.getTime ();

		if (strLocation.toUpperCase ().equals ("UK"))
			dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		else if (strLocation.toUpperCase ().equals ("USA") || strLocation.toUpperCase ().equals ("US"))
			dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
		else
			return "Please choose either UK or US / USA.";

		randomDate = dateFormat.format (rDate);
		return randomDate;

	}

	public static String fileDateTime ()
	{
		DateFormat dateFormat = new SimpleDateFormat ("ddMMyyyy_HHmmss");
		Date date = new Date ();
		String fileDateTime = dateFormat.format (date);
		System.out.println (fileDateTime); // 29012018_100841
		return fileDateTime;

	}

}
