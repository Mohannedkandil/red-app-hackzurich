import React from "react";
import {ImageBackground, StyleSheet, View} from 'react-native';

import {Center, Circle, Container, Flex, Heading, Image, Pressable, Progress, Text, VStack, ZStack} from "native-base";

const passportData = [
    {name: "Gundeldingen", city: "Basel", image: require('../assets/stores/migros1.png')},
    {name: "MPark", city: "Basel", image: require('../assets/stores/migros2.png')},
    {name: "Altmarkt", city: "Zürich", image: require('../assets/stores/migros4.png')},
    {name: "Bahnhof", city: "Basel", image: require('../assets/stores/migros3.png')},
]

export default function Profile({navigation}) {
    return (
        <View flex={1}>
            <ImageBackground source={require('../assets/background.png')} style={{flex: 1, resizeMode: 'cover', justifyContent: 'center'}}>
                <Text fontWeight="bold" color="black" alignSelf="center" fontSize={30}>SuperBuyer5</Text>
                <Container style={{alignSelf: "center", height: "34%"}}>
                    <ZStack alignSelf="center">
                        <Circle size={200} bg="#ED702D" alignSelf="center" marginTop={12}/>
                        <Image
                            style={{alignSelf: 'center'}}
                            size="2xl"
                            source={require('../assets/avatar.png')}
                            alt="avatar"
                        />
                    </ZStack>
                </Container>
                <Text textAlign="center" bold fontSize="18px">Level 12</Text>

                <VStack mt="25px" space={2}>
                    <Text fontSize={14} fontWeight="bold" alignSelf="center">GREEN HERO</Text>
                    <Center><Progress value={35} width="200px"/></Center>
                    <Text fontSize={14} fontWeight="bold" alignSelf="center">135225 / 30000 XP</Text>
                </VStack>

                <Heading mt="20px" mb="3" ml={3}>Passport</Heading>
                <Flex direction="row" wrap="wrap" justifyContent="space-between">
                    {passportData.slice(0, 3).map((x, index) => <Flex key={index} direction="column" alignItems="center" ml="10px"
                                                                      mr="10px">
                        <Image source={x.image} size="45px" alt="Store 1"/>
                        <Text fontSize={14} fontWeight="bold" mt="4px" textAlign="center">{x.name} {"\n"} {x.city}</Text>
                    </Flex>)}
                </Flex>

                <Center mt="40px">
                    <Pressable onPress={() => navigation.navigate("Home")}>
                        <Image size="55px" source={require('../assets/menu/icon-close.png')} alt="Back to home screen"/>
                    </Pressable>
                </Center>
            </ImageBackground>
        </View>
    );
}

const styles = StyleSheet.create({
    avatar: {
        alignSelf: 'center',
        marginTop: "16%",
    },
    username: {
        fontSize: 25,
        fontWeight: 'bold',
        color: 'black',
        alignSelf: 'center',
        marginTop: "10%"
    },
})

