import React from "react";
import {Container, HStack, Icon, IconButton, View, Text} from "native-base";
import ChallengeTabView from "../components/ChallengeTabView";
import LeaderboardTabView from "../components/LeaderboardTabView";
import {Entypo} from "@expo/vector-icons";
import MenuStagger from "../components/MenuStagger";

export default function Home({ navigation }) {
    return (
        <View flex={1} ml={3} mr={3} mt={10}>
            <ChallengeTabView/>
            <LeaderboardTabView/>
            <HStack justifyContent="space-between" mb="5" alignText="bottom">
                <IconButton
                    icon={<Icon as={Entypo} name="user"/>}
                    borderRadius="full"
                    _icon={{color: "#ED702D"}}
                    onPress={() => navigation.navigate("Profile")}
                />
                <MenuStagger/>
                <IconButton
                    icon={<Icon as={Entypo} name="camera"/>}
                    borderRadius="full"
                    _icon={{color: "#ED702D"}}
                    onPress={() => navigation.navigate("ScanProduct")}
                />
            </HStack>
        </View>
    );
}


