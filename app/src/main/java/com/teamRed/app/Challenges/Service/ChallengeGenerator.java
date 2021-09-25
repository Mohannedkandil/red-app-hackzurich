package com.teamRed.app.Challenges.Service;

import com.teamRed.app.Challenges.Model.Challenge;
import com.teamRed.app.Challenges.Model.ChallengeDuration;
import com.teamRed.app.Task.Service.TaskGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChallengeGenerator {

    public static final String SCANNING_CHALLENGE = "Product Scanning Challenge";

    public static Challenge generateStampChallenge() {
        return new Challenge("0", "Collect Stamps", "Get a stamp per visit to Migros", TaskGenerator.parameterTaskTypeStamp(), 500, ChallengeDuration.THREE_MONTHS, LocalDateTime.now());
    }

    public static Challenge generateWeeklyProductScanningChallenge() {
        return new Challenge("1", SCANNING_CHALLENGE, "Scan a product 10 times in a week at Migros", TaskGenerator.parameterTaskTypeProductScanningTen(), 100, ChallengeDuration.WEEKLY, LocalDateTime.now());
    }

    public static Challenge generateMonthlyProductScanningChallenge() {
        return new Challenge("2", SCANNING_CHALLENGE, "Scan a product 100 times in a week at Migros", TaskGenerator.parameterTaskTypeProductScanningHundred(), 1000, ChallengeDuration.MONTHLY, LocalDateTime.now());
    }

    public static Challenge generateWeeklyProductScanningChallengeThreeStar() {
        return new Challenge("3", SCANNING_CHALLENGE, "Scan a three starred product 10 times in a week at Migros", TaskGenerator.parameterTaskTypeProductScanningTen(), 300, ChallengeDuration.WEEKLY, LocalDateTime.now());
    }

    public static Challenge generateWeeklyProductScanningChallengeFiveStar() {
        return new Challenge("4", SCANNING_CHALLENGE, "Scan a five starred product 10 times in a week at Migros", TaskGenerator.parameterTaskTypeProductScanningTen(), 500, ChallengeDuration.WEEKLY, LocalDateTime.now());
    }

    public static List<Challenge> generateEveryChallenge() {
        var challengeList = new ArrayList<Challenge>();
        challengeList.add(generateStampChallenge());
        challengeList.add(generateWeeklyProductScanningChallenge());
        challengeList.add(generateMonthlyProductScanningChallenge());
        challengeList.add(generateWeeklyProductScanningChallengeThreeStar());
        challengeList.add(generateWeeklyProductScanningChallengeFiveStar());
        return challengeList;
    }
  }
