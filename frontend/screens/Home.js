import React from "react";
import {View} from "native-base";
import Challenges from "../components/Challenges";
import LeaderboardTabView from "../components/LeaderboardTabView";

export default function Home({navigation}) {
    return (
        <View flex={1} ml={3} mr={3}>
            <Challenges/>
            <LeaderboardTabView/>
        </View>
    );
}

// {/*<IconButton*/}
// {/*    icon={<Icon as={Entypo} name="camera"/>}*/}
// {/*    borderRadius="full"*/}
// {/*    _icon={{*/}
// {/*        color: "orange.500",*/}
// {/*        size: "md",*/}
// {/*    }}*/}
// {/*    onPress={() => navigation.navigate("ScanProduct")}*/}
// {/*/>*/}
// {/*<IconButton*/}
// {/*    icon={<Icon as={Entypo} name="user"/>}*/}
// {/*    borderRadius="full"*/}
// {/*    _icon={{*/}
// {/*        color: "orange.500",*/}
// {/*        size: "md",*/}
// {/*    }}*/}
// {/*    onPress={() => navigation.navigate("Profile")}*/}
// {/*/>*/}
