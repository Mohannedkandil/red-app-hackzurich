import React from "react";
import {View} from "react-native";
import {Button, Center, HStack, Image, Pressable, Text, VStack, ZStack} from "native-base";


export default function WeeklyChallenge({navigation}) {
    return (
        <View style={{backgroundColor: '#ED702D', flex: 1}}>
            <HStack space={2} alignItems="center" mt={50} padding={10} width={300}>
                <Image
                    source={
                        require('../assets/component_24.png')
                    }
                    size="80px"
                    alt="dummy"
                />
                <Text color="white" fontSize="xl" fontWeight="bold" lineHeight="23" alignItems="center">
                    Weekly challenge product found! 500XP

                </Text>
            </HStack>
            <HStack space={3} height={200}>
                <Text fontWeight={700} fontSize={25} textAlign="left" color="white" ml={4}>Bio V-Love Pesto {"\n"} Genovese {"\n"} CHF
                    2.90</Text>
                <ZStack>

                    <Image
                        alt="dummy"
                        source={require('../assets/bio.png')}
                    />
                </ZStack>
            </HStack>

            <Image
                alt="dummy"
                source={{
                    src: 'https://i.ibb.co/n38XRqW/m-check2-1.png'
                }}
            />

            <VStack space={3} alignItems="center" height="100">
                <Image
                    source={require('../assets/m-check.png')}
                    alt="dummy"
                />
                <Text lineHeight={16} fontWeight={700} fontSize={16} color="white" textAlign="left" ml={4} width="340">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean
                    tincidunt leo nunc. Aliquam consequat in turpis sit amet suscipit.
                    Mauris ut magna sit amet lectus rhoncus mattis. Curabitur tempor venenatis auctor.
                    Phasellus lacinia dolor augue, eget ultrices felis tempor lobortis.
                </Text>
            </VStack>
            <VStack>
                <Center>
                    <Button bg="#ffffff" width="300px" mt="150px">
                        <Text color="black">Add to cart</Text>
                    </Button>
                    <Pressable mt="40px" mb="7" onPress={() => navigation.navigate("Home")}>
                        <Image size="55px" source={require('../assets/menu/icon-close.png')} alt="Back to home screen"/>
                    </Pressable>
                </Center>
            </VStack>
        </View>
    );

}
