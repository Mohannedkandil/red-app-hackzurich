import React from "react";
import {Box, Center, Circle, HStack, Image, Progress, Text, VStack} from "native-base";
import {Animated, Dimensions, Pressable, StatusBar} from "react-native";
import {SceneMap, TabView} from "react-native-tab-view";

// TODO: Use real data
const dailyChallenges = [
    {name: "Scan a Bio Marroni", xp: 500},
    {name: "Buy 5 animal welfare products", xp: 750, progress: 60},
    {name: "Buy 3 5-star M-Check products", xp: 750, progress: 33},
]

const monthlyChallenges = [
    {name: "Visit Migros 10 times", xp: 5000, progress: 25},
    {name: "Buy 25 M-Check products", freeProductId: 123, progress: 45},
    {name: "Scan 100 items", xp: 2000, progress: 85},
]

const DailyTab = () => <Center><Image size="225px" source={require('../assets/daily-challenges.png')} alt="daily"/></Center>;

const WeeklyTab = () => <VStack space={1.5} mt="1.5">{dailyChallenges.map((elem, index) => {
    return <HStack key={index} space={3} justifyContent="space-between" alignItems="center" rounded="10px" padding="2" paddingTop="1.5"
                   paddingBottom="1.5" borderWidth="2px" borderColor="#ED702D" bg="white">
        <VStack textAlgin="left" width="75%">
            <Text bold>{elem.name}</Text>
            {elem.progress && <Progress mt="1" value={elem.progress} bg="#EEEEEE"/>}
        </VStack>
        <Circle size="45px" bg="#ED702D">
            <Text fontSize="13px" textAlign="center" color="#ffffff">{elem.xp} {"\n"}XP</Text>
        </Circle>
    </HStack>
})}</VStack>

const MonthlyTab = () => <VStack space={1.5} mt="1.5">{monthlyChallenges.map((elem, index) => {
    return <HStack key={index} space={3} justifyContent="space-between" alignItems="center" rounded="10px" padding="2" paddingTop="1.5"
                   paddingBottom="1.5" borderWidth="2px" borderColor="#ED702D" bg="white">
        <VStack textAlgin="left" width="75%">
            <Text bold>{elem.name}</Text>
            {elem.progress && <Progress mt="1" value={elem.progress} bg="#EEEEEE"/>}
        </VStack>
        <Circle size="45px" maxSize="45" bg="#ED702D" flex={1}>
            {
                elem.xp
                    ? <Text fontSize="13px" textAlign="center" color="#ffffff">{elem.xp} {"\n"}XP</Text>
                    :
                    <Image alt="free product" source={require('../assets/free-product.jpg')} width="20px" maxWidth="100%" maxHeight="100%"/>
            }
        </Circle>
    </HStack>
})}</VStack>;

const initialLayout = {width: Dimensions.get('window').width};

const renderScene = SceneMap({
    daily: DailyTab,
    weekly: WeeklyTab,
    monthly: MonthlyTab,
});

export default function ChallengeTabView() {

    const [index, setIndex] = React.useState(1);
    const [routes] = React.useState([
        {key: 'daily', title: 'Daily'},
        {key: 'weekly', title: 'Weekly'},
        {key: 'monthly', title: 'Monthly'},
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
            navigationState={{index, routes}}
            renderScene={renderScene}
            renderTabBar={renderTabBar}
            onIndexChange={setIndex}
            initialLayout={initialLayout}
            style={{marginTop: StatusBar.currentHeight}}
        />
    );
}
