import React from "react";
import {HStack, Icon, IconButton, View} from "native-base";
import Challenges from "../components/Challenges";
import LeaderboardTabView from "../components/LeaderboardTabView";
import {Entypo} from "@expo/vector-icons";
import MenuStagger from "../components/MenuStagger";

export default function Home({navigation}) {
    return (
        <View flex={1} ml={3} mr={3} mt={10}>
            <Challenges/>
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


