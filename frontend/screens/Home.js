import React from "react";
import {HStack, Image, Pressable, View} from "native-base";
import ChallengeTabView from "../components/ChallengeTabView";
import LeaderboardTabView from "../components/LeaderboardTabView";

export default function Home({navigation}) {
    return (
        <View flex={1} ml={3} mr={3} mt={10}>
            <ChallengeTabView/>
            <LeaderboardTabView/>
            <HStack justifyContent="space-between" mb="7" alignText="center" mt="70px">
                <Pressable onPress={() => navigation.navigate("Challenges")}>
                    <Image size="55px" source={require('../assets/menu/icon-challenges.png')} alt="show challenges"/>
                </Pressable>
                <Pressable onPress={() => navigation.navigate("Profile")}>
                    <Image size="55px" source={require('../assets/menu/icon-profile.png')} alt="Show profile"/>
                </Pressable>
                <Pressable onPress={() => navigation.navigate("ScanProduct")}>
                    <Image size="55px" source={require('../assets/menu/icon-camera-on.png')} alt="Start scanning"/>
                </Pressable>
            </HStack>
        </View>
    );
}


