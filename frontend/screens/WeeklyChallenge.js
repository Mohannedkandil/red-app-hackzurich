import React from "react";
import { View, StyleSheet } from "react-native";
import { Container, Icon, IconButton, Text, Circle, Center, VStack, HStack, ZStack, Image, Box, Button } from "native-base";
import { Entypo } from "@expo/vector-icons";


export default function WeeklyChallenge() {
    return (
        <View style={{ backgroundColor: '#ED702D', flex: 1 }}>
            <HStack space={2} alignItems="center" mt={50} padding={10} width={300}>
                <Image
                    source={
                        require('../assets/component_24.png')
                    }
                    size="80px"
                />
                <Text color="white" fontSize="xl" fontWeight="bold" lineHeight="23" alignItems="center">
                    Weekly challenge product found! 500XP

                </Text>
            </HStack>
            <HStack space={3} height={200}>
                <Text fontWeight={700} fontSize={25} textAlign="left" color="white" ml={4}>Bio V-Love Pesto {"\n"} Genovese {"\n"} CHF 2.90</Text>
                <ZStack>

                    <Image

                        source={require('../assets/bio.png')}
                    />
                </ZStack>
            </HStack>

            <Image

                source={{
                    src: 'https://i.ibb.co/n38XRqW/m-check2-1.png'
                }}
            />

            <VStack space={3} alignItems="center" height="100" >
                <Image

                    source={require('../assets/m-check.png')}
                />
                <Text lineHeight={16} fontWeight={700} fontSize={16} color="white" textAlign="left" ml={4} width="340">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean
                    tincidunt leo nunc. Aliquam consequat in turpis sit amet suscipit.
                    Mauris ut magna sit amet lectus rhoncus mattis. Curabitur tempor venenatis auctor.
                    Phasellus lacinia dolor augue, eget ultrices felis tempor lobortis.
                </Text>
            </VStack>
            <HStack space={5} alignSelf="center" top={200}>

                <Circle size={30} bg="#FFFFFF" alignContent="center">
                    <IconButton
                        icon={<Icon as={Entypo} name="cross" />}
                        borderRadius="full"
                        _icon={{
                            color: "#ED702D",
                            size: "md",
                        }}
                        onPress={() => console.log("Close Checkout")}
                    />
                </Circle>
                <Button colorScheme="light" ml={20}>
                    <Text color="#ED702D">Add to cart</Text>
                </Button>
            </HStack>
        </View >
    );

}