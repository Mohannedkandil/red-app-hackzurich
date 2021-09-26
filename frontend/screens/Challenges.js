import React from "react";
import {Center, Flex, Heading, Image, Pressable, Progress, Text, VStack} from "native-base";
import ChallengeTabView from "../components/ChallengeTabView";

const data = [
    {imageLink: require('../assets/achievements/1.png'), xpAchieved: 500, xpTotal: 500},
    {imageLink: require('../assets/achievements/2.png'), xpAchieved: 421, xpTotal: 500},
    {imageLink: require('../assets/achievements/3.png'), xpAchieved: 401, xpTotal: 500},
    {imageLink: require('../assets/achievements/4.png'), xpAchieved: 357, xpTotal: 500},
    {imageLink: require('../assets/achievements/5.png'), xpAchieved: 302, xpTotal: 500},
    {imageLink: require('../assets/achievements/6.png'), xpAchieved: 280, xpTotal: 500},
    {imageLink: require('../assets/achievements/7.png'), xpAchieved: 252, xpTotal: 500},
    {imageLink: require('../assets/achievements/8.png'), xpAchieved: 134, xpTotal: 250},
    {imageLink: require('../assets/achievements/9.png'), xpAchieved: 144, xpTotal: 250},
    {imageLink: require('../assets/achievements/10.png'), xpAchieved: 120, xpTotal: 250},
    {imageLink: require('../assets/achievements/11.png'), xpAchieved: 111, xpTotal: 250},
    {imageLink: require('../assets/achievements/12.png'), xpAchieved: 108, xpTotal: 250},
    {imageLink: require('../assets/achievements/13.png'), xpAchieved: 108, xpTotal: 250},
    {imageLink: require('../assets/achievements/14.png'), xpAchieved: 45, xpTotal: 100},
    {imageLink: require('../assets/achievements/15.png'), xpAchieved: 3, xpTotal: 100},
];

export default function Challenges({navigation}) {

    return <VStack flex={1} ml={3} mr={3} mt={10} mb={0}>
        <Heading mt="4" mb="3">Challenges</Heading>
        <ChallengeTabView/>
        <Heading mb={5}>Achievements</Heading>
        <Flex direction="row" flex={1} flexWrap="wrap" justifyContent="space-between">
            {
                data.map((x, index) => <Flex key={index} mb="20px" mr="7px" ml="7px" direction="column" alignItems="center">
                    <Image size="50px" source={x.imageLink} alt="dummy"/>
                    <Progress value={100}/>
                    <Text>{x.xpAchieved}/{x.xpTotal}</Text>
                </Flex>)
            }
        </Flex>
        <Center>
            <Pressable mt="40px" mb="7" onPress={() => navigation.navigate("Home")}>
                <Image size="55px" source={require('../assets/menu/icon-close.png')} alt="Back to home screen"/>
            </Pressable>
        </Center>
    </VStack>
}
