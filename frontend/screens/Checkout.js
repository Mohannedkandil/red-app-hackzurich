import React from "react";
import { View, StyleSheet } from "react-native";
import {Container, Icon, IconButton, Text, Circle, Center, Stack, HStack, Image, Pressable} from "native-base";
import { Entypo } from "@expo/vector-icons";

export default function Checkout({ navigation }) {
    return (
        <View style={{ backgroundColor: '#ED702D', flex: 1 }}>
            <HStack space={2} alignItems="center" mt={50} padding={10} width={300}>
                <Image
                    alt="dummy"
                    source={
                        require('../assets/component_24.png')
                    }
                    size="80px"
                />
                <Text color="white" fontSize="xl" fontWeight="bold" lineHeight="23" alignItems="center">
                    Are you sure you scanned all products?
                </Text>
            </HStack>
            <Center px="5">
                <Circle size={235} bg="#FFFFFF" shadow="2">
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">12'025</Text>
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">XP</Text>
                </Circle>
            </Center>
            <Center flex={1} mt={20}>
                <Pressable onPress={() => navigation.navigate("Home")} mt="15px">
                    <Image size="55px" source={require('../assets/menu/icon-close.png')} alt="Back to home screen"/>
                </Pressable>
            </Center>
        </View>

    );
}
