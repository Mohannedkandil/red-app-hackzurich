import React from "react";
import Leaderboard from "./Leaderboard";
import {Box} from "native-base";
import {Animated, Dimensions, Pressable, StatusBar} from "react-native";
import {SceneMap, TabView} from "react-native-tab-view";

const currentStoreName = "Gundeldingen, Basel";

const storeLeaderboardData = [
    {
        name: "Abc",
        xp: 750,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Def",
        xp: 400,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Lddf",
        xp: 300,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Adrian",
        xp: 101,
        position: 45,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
];

const switzerlandLeaderboardData = [
    {
        name: "Altmarkt, Bern",
        xp: 113875,
    },
    {
        name: "HB, Zürich",
        xp: 109875,
    },
    {
        name: "Plaza, Lugano",
        xp: 88875,
    },
    {
        name: "Gundeldingen, Basel",
        xp: 61875,
        position: 5,
    },
];

const StoreTab = () => Leaderboard({currentStoreName, leaderboardData: storeLeaderboardData, mode: "store"});
const SwitzerlandTab = () => Leaderboard({currentStoreName, leaderboardData: switzerlandLeaderboardData, mode: "switzerland"});

const initialLayout = {width: Dimensions.get('window').width};

const renderScene = SceneMap({
    store: StoreTab,
    switzerland: SwitzerlandTab,
});

export default function LeaderboardTabView() {

    const [index, setIndex] = React.useState(0);
    const [routes] = React.useState([
        {key: 'store', title: 'Store'},
        {key: 'switzerland', title: 'Switzerland'},
    ]);

    const renderTabBar = (props) => {
        const inputRange = props.navigationState.routes.map((x, i) => i);
        return <Box flexDirection="row">
            {props.navigationState.routes.map((route, i) => {
                const opacity = props.position.interpolate({
                    inputRange,
                    outputRange: inputRange.map((inputIndex) =>
                        inputIndex === i ? 1 : 0.5
                    ),
                });
                const color = index === i ? '#ED702D' : '#444444';
                const borderColor = index === i ? '#ED702D' : 'transparent';

                return (
                    <Box
                        borderBottomWidth="3"
                        borderColor={borderColor}
                        flex={1}
                        alignItems="center"
                        p="2"
                        cursor="pointer"
                        mb="2"
                        key={i}
                    >
                        <Pressable
                            onPress={() => setIndex(i)}>
                            <Animated.Text style={{color, fontSize: 17, fontWeight: "bold"}}>{route.title}</Animated.Text>
                        </Pressable>
                    </Box>
                );
            })}
        </Box>
    };

    return (
        <TabView
            flex={1}
            navigationState={{index, routes}}
            renderScene={renderScene}
            renderTabBar={renderTabBar}
            onIndexChange={setIndex}
            initialLayout={initialLayout}
            style={{marginTop: StatusBar.currentHeight}}
        />
    );

}
