import React from "react";
import {View} from "native-base";
import Challenges from "../components/Challenges";
import LeaderboardTabView from "../components/LeaderboardTabView";

export default function Home({navigation}) {
    return (
        <View flex={1} ml={3} mr={3} mt={10}>
            <Challenges/>
            <LeaderboardTabView/>
        </View>
    );
}


