package com.crimeforcast.service.impl.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.crimeforcast.entitys.Crimeforcastdataset;
import com.crimeforcast.entitys.Localdataset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataminingClassification {

	Float avargeMurderInState = 0.0f;
	Map<String, String> predictionResult = new HashMap<>();
	private Integer CRIME_PREDICTION_PRECENT = 0;
	private Float predictionResultPrecent = 0.0f;

	public DataminingClassification() {

	}

	public <T> String PredictionResult(String stateName, List<Localdataset> placeList, Session session)
			throws JsonProcessingException {

		StringBuffer messageHeader = new StringBuffer();
		HashSet<String> typeOfCrime = new HashSet<>();
		for (Localdataset localdataset : placeList) {
			typeOfCrime.add(localdataset.getTypeOf_Crime());
		}
		for (String crime : typeOfCrime) {
			char firstLetter = crime.charAt(0);
			messageHeader.append("<br>" + Character.toUpperCase(firstLetter) + " - <code>" + crime + "</code>\n");
		}

		StringBuffer firstResult = getMiningHistoryResult(stateName, placeList, session);
		StringBuffer secondResult = getLocaldataMiningResult(stateName, placeList, session);
		System.out.println("Total value is = " + CRIME_PREDICTION_PRECENT);
		predictionResultPrecent = (float) ((100 * CRIME_PREDICTION_PRECENT) / 234);
		messageHeader
				.append("<br><br>Precent Of Crime Occurance is About : <code>" + predictionResultPrecent + "</code>");
		StringBuffer totalResult = new StringBuffer();
		totalResult.append(messageHeader);
		totalResult.append(firstResult);
		totalResult.append(secondResult);
		totalResult
				.append("<blockquote><p>As terrorist attacks, political upheaval, and violence often take place without any warning,all citizens are strongly encouraged to maintain a high level of vigilance and take appropriate steps to increase their security awareness when traveling. To better prepare for possible emergencies, all citizens are encouraged to read Country Specific Information pages, Travel Warnings, and Travel Alerts on travel.state.gov before planning a trip.</p><footer>Central Government Tourism of India  <cite title="
						+ "travel guide" + ">travel guide</cite></footer></blockquote>");

		String message = totalResult.toString();
		System.out.println(predictionResultPrecent);

		predictionResult.put("message", message);
		predictionResult.put("place", placeList.get(0).getPlace());
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(predictionResult);
		return jsonData;
	}

	// method to mining In CrimeHistory Data set
	@SuppressWarnings("unchecked")
	private StringBuffer getMiningHistoryResult(String stateName, List<Localdataset> placeList, Session session) {
		StringBuffer firstResult = new StringBuffer();
		try {
			List<Crimeforcastdataset> crimeforcastdatasets = session.createCriteria(Crimeforcastdataset.class)
					.add(Restrictions.eq("state_ut", stateName)).list();
			Long totalCrimePerState = 0l;
			Integer muder = 0;
			for (Crimeforcastdataset crimeforcastdataset : crimeforcastdatasets) {
				totalCrimePerState = totalCrimePerState + crimeforcastdataset.getTotal_ipc_crimes();
				totalCrimePerState = totalCrimePerState + crimeforcastdataset.getOther_ipc_crimes();
				muder = muder + crimeforcastdataset.getMurder();
			}
			System.out.println("totalCrimePerState " + totalCrimePerState);
			System.out.println("murder " + muder);
			if (muder != 0) {
				avargeMurderInState = (float) ((100 * muder) / totalCrimePerState);
			}

			firstResult.append("<br><br><p>The total crime registered from <bclass=" + "text-primary" + ">"
					+ stateName.toUpperCase() + "</b>  is <b><code>" + totalCrimePerState + "</code></b>.");

			return firstResult;
		} catch (Exception exception) {
			exception.printStackTrace();
			return firstResult.append("");
		}
	}

	public StringBuffer getLocaldataMiningResult(String stateName, List<Localdataset> placeList, Session session)
			throws JsonProcessingException {
		System.out.println("input Local DataSet : " + placeList);
		StringBuffer secondResult = new StringBuffer();
		int totalCase = placeList.size();
		String placeName = placeList.get(0).getPlace();
		String placeType = placeList.get(0).getLocationType();
		List<Localdataset> fiftyAbove = new ArrayList<>();
		List<Localdataset> tewntyFiveAbove = new ArrayList<>();
		List<Localdataset> tewntyFiveBelow = new ArrayList<>();
		int localMurder = 0;
		List<LocationLablePojo> lablePojos = new ArrayList<>();
		StringBuffer crimeList = new StringBuffer();
		int maleCount = 0;
		int femaleCount = 0;
		List<String> maxCrimeName = new ArrayList<>();
		for (Localdataset localdataset : placeList) {
			maxCrimeName.add(localdataset.getTypeOf_Crime());
			if (localdataset.getSuspectGender().equals("male")) {
				maleCount = maleCount + 1;
			} else {
				femaleCount = femaleCount + 1;
			}
			LocationLablePojo lablePojo = new LocationLablePojo();
			lablePojo.setPlace(localdataset.getPlace());
			lablePojo.setLatitude(localdataset.getLatitude());
			lablePojo.setLongitude(localdataset.getLongitude());
			lablePojo.setIcon(Character.toUpperCase(localdataset.getTypeOf_Crime().charAt(0)));
			lablePojo.setCaseFullForm(localdataset.getTypeOf_Crime());
			lablePojos.add(lablePojo);
			if (localdataset.getSuspectAge() > 50) {
				fiftyAbove.add(localdataset);
			} else if (localdataset.getSuspectAge() > 25) {
				tewntyFiveAbove.add(localdataset);
			} else if (localdataset.getSuspectAge() < 25) {
				tewntyFiveBelow.add(localdataset);
			}
			if (localdataset.getTypeOf_Crime().equalsIgnoreCase("murder")) {
				localMurder = localMurder + 1;
			}
			crimeList.append("<code>" + localdataset.getTypeOf_Crime() + "</code> ");
		}

		ObjectMapper objectMapper = new ObjectMapper();
		String cordianteLabelJASON = objectMapper.writeValueAsString(lablePojos);
		predictionResult.put("cord", cordianteLabelJASON);

		Float localMurderRate = 0.0f;
		if (localMurder != 0)
			localMurderRate = (float) ((100 * localMurder) / totalCase);

		System.out.println(localMurderRate);

		Float fiftyAbovePercent = 0.0f;
		if (!fiftyAbove.isEmpty())
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
					+ NaiveBayesianClassificationPoints.SUSPECT_AGE_ABOVE_50;
		fiftyAbovePercent = (float) ((100 * fiftyAbove.size()) / totalCase);

		Float tewntyFiveAbovePercent = 0.0f;
		if (!tewntyFiveAbove.isEmpty())
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
					+ NaiveBayesianClassificationPoints.SUSPECT_AGE_ABOVE_25;
		tewntyFiveAbovePercent = (float) ((100 * tewntyFiveAbove.size()) / totalCase);

		Float tewntyFiveBelowPercent = 0.0f;
		if (!tewntyFiveBelow.isEmpty())
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
					+ NaiveBayesianClassificationPoints.SUSPECT_AGE_BELOW_25;
		tewntyFiveBelowPercent = (float) ((100 * tewntyFiveBelow.size()) / totalCase);

		String genderStatus;
		Float genderCountPercentage = 0.0f;
		if (maleCount > femaleCount) {
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT + NaiveBayesianClassificationPoints.VICTIM_GENDER_MALE;
			genderStatus = "Majority of cases are registred to <b>MALE</b> ";
			genderCountPercentage = (float) ((100 * maleCount) / totalCase);
		} else if (femaleCount > maleCount) {
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
					+ NaiveBayesianClassificationPoints.VICTIM_GENDER_FEMALE;
			genderStatus = "Majority of cases are registred to <b>FEMALE</b> ";
			genderCountPercentage = (float) ((100 * femaleCount) / totalCase);
		} else {
			genderStatus = "Case registred to Male and Female was Equal ";
		}

		String mostRepeatedCrime = "<code>" + mostCommon(maxCrimeName).toUpperCase()
				+ "</code> is the repeated case in this area.";

		if (placeType.equals("city"))
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT + NaiveBayesianClassificationPoints.CITY_AREA;
		else
			CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT + NaiveBayesianClassificationPoints.RURAL_AREA;

		secondResult.append("<br>Place Name Is : " + placeName.toUpperCase() + ", Area Type is <code>" + placeType
				+ "</code><br></p>");
		secondResult.append("<p>Total Case Reported : <code>" + placeList.size() + "</code>.<p>");
		secondResult.append("<p><b><u>Rate per Age :</u></b> <br>&emsp;&emsp;&emsp;Senior Citizen :<code>"
				+ fiftyAbovePercent + "</code>.</p>");
		secondResult.append("<p>&emsp;&emsp;&emsp;Above 25yr :<code>" + tewntyFiveAbovePercent + "</code>.</p>");
		secondResult.append("<p>&emsp;&emsp;&emsp;Below 25yr :<code>" + tewntyFiveBelowPercent + "</code>.</p>");
		secondResult.append("<p>Registered Murder Rate : <code>" + avargeMurderInState + "</code>");
		secondResult
				.append("<p>" + genderStatus + "(" + genderCountPercentage + "%). <br>" + mostRepeatedCrime + "</p>");

		secondResult.append(getThirdResult(stateName, placeList, session));

		secondResult.append("<p></p>" + "<dl>" + "<dt>Nearest Police Station :</dt>" + "<code>"
				+ placeList.get(0).getNearestPoliceStation() + "</code><br>" + "<dt>Registered Crime Data :</dt>"
				+ crimeList + "</dl> ");
		secondResult.append("</p>");
		return secondResult;
	}

	public static <T> T mostCommon(List<T> list) {
		Map<T, Integer> map = new HashMap<>();

		for (T t : list) {
			Integer val = map.get(t);
			map.put(t, val == null ? 1 : val + 1);
		}

		Entry<T, Integer> max = null;

		for (Entry<T, Integer> e : map.entrySet()) {
			if (max == null || e.getValue() > max.getValue())
				max = e;
		}

		return max.getKey();
	}

	public StringBuffer getThirdResult(String stateName, List<Localdataset> placeList, Session session) {
		StringBuffer thirdResult = new StringBuffer();
		int totalCase = placeList.size();
		int victimCount = 0;
		int warningAbove40 = 0;
		int warningAbove25 = 0;
		int warningbelow25 = 0;

		for (Localdataset localdataset : placeList) {
			if (localdataset.getVictimGender().equals("female")) {
				victimCount = victimCount + 1;
			}

			if (Integer.parseInt(localdataset.getVictimAge()) > 40) {
				warningAbove40 = warningAbove40 + 1;
			} else if (Integer.parseInt(localdataset.getVictimAge()) > 25) {
				warningAbove25 = warningAbove25 + 1;
			} else {
				warningbelow25 = warningbelow25 + 1;
			}
		}

		CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
				+ warningAbove40 * NaiveBayesianClassificationPoints.VICTIM_AGE_40;
		CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
				+ warningAbove25 * NaiveBayesianClassificationPoints.VICTIM_AGE_ABOVE_25;
		CRIME_PREDICTION_PRECENT = CRIME_PREDICTION_PRECENT
				+ warningbelow25 * NaiveBayesianClassificationPoints.VICTIM_BELOW_25;

		Float femaleVictimRate = 0.0f;
		if (victimCount != 0)
			femaleVictimRate = (float) ((100 * victimCount) / totalCase);
		if (femaleVictimRate > 30.0f)
			thirdResult.append(
					"Harassment against women is very High and case registered is upto " + femaleVictimRate + "%, ");

		String warningForageGroup;

		if (warningAbove40 > warningAbove25 && warningAbove40 > warningbelow25)
			warningForageGroup = "Above 40 age is majority of victim in this area, ";
		else if (warningAbove25 > warningAbove40 && warningAbove25 > warningbelow25)
			warningForageGroup = "Middel age group are the victim of majority of the crime,";
		else
			warningForageGroup = "Age below 25 should be on alert, majority of Victim in this area is teen age and child.";

		thirdResult.append(warningForageGroup);

		return thirdResult;
	}

}
