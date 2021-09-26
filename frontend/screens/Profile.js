import React from "react";
import {ImageBackground, StyleSheet, View} from 'react-native';

import { Text, Avatar, HStack, VStack, Progress, Center, Container, Image, Box, Stack, Heading, Circle, ZStack, Square } from "native-base";
import { alignSelf, flex, flexDirection } from "styled-system";
import Icon from 'react-native-vector-icons/FontAwesome';


export default function Profile() {
    return (
        <View flex={1}>
            <ImageBackground source={require('../assets/background.png')} style={{flex: 1, resizeMode: 'cover', justifyContent: 'center'}}>
            <Text fontWeight="bold" color="black" alignSelf="center" marginTop={10} fontSize={30}>SuperBuyer5</Text>
            <Container style={{ alignSelf: "center", height: "34%" }}>
                <ZStack alignSelf="center">
                    <Circle size={200} bg="#ED702D" alignSelf="center" marginTop={12}>
                        <Text>Level</Text>

                    </Circle>

                    <Image
                        style={{ alignSelf: 'center' }}
                        size="2xl"
                        source={{
                            uri: "https://i.ibb.co/BGQsgfW/emoji.png",
                        }}
                    />
                </ZStack>
            </Container>
            <Box alignItems="center">
                <Text fontSize={14} fontWeight={700}>Level</Text>
                <Text fontSize={30} fontWeight="bold">12</Text>

            </Box>
            <Box wdith="220">
                <Text fontSize={14} fontWeight="bold" alignSelf="center">GREEN HERO!</Text>
                <Progress value={30} mx="2" />
                <Text fontSize={14} fontWeight="bold" alignSelf="center">135'225 / 300'00 XP</Text>
            </Box>

            <HStack space={5} justifyContent="center" mt={7}>
                <VStack space={2}>
                    <Image
                        source={
                            require('../assets/badges/badge_1.png')
                        }
                        size="lg"
                    />
                    <Text fontSize={14} fontWeight="bold" textAlign="center">Gundeldingen {"\n"} Basel</Text>

                </VStack>

                <VStack space={2}>
                    <Image
                        source={
                            require('../assets/badges/badge_1.png')
                        }
                        size="lg"
                    />
                    <Text fontSize={14} fontWeight="bold" textAlign="center">Gundeldingen {"\n"} Basel</Text>

                </VStack>
                <VStack space={2}>
                    <Image
                        source={
                            require('../assets/badges/badge_1.png')
                        }
                        size="lg"
                    />
                    <Text fontSize={14} fontWeight="bold" textAlign="center">Gundeldingen {"\n"} Basel</Text>

                </VStack>




            </HStack>
            </ImageBackground>
        </View >
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

