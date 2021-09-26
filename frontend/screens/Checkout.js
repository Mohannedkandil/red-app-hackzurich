import React from "react";
import { View, StyleSheet } from "react-native";
import { Container, Icon, IconButton, Text, Circle, Center, Stack, HStack, Image } from "native-base";
import { Entypo } from "@expo/vector-icons";

export default function Checkout({ navigation }) {
    return (
        <View style={{ backgroundColor: '#ED702D', flex: 1 }}>
            <HStack space={2} alignItems="center" mb={20} flex={1}>
                <Image
                    source={
                        require('../assets/component_24.png')
                    }
                    size="80px"
                />
                <Text color="white" fontSize="xl" fontWeight="bold" lineHeight="23">
                    Transfering cart. Please proceed on the checkout machine.
                </Text>
            </HStack>
            <Center px="5">
                <Circle size={235} bg="#FFFFFF" shadow="2">
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">12'025</Text>
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">XP</Text>
                </Circle>
            </Center>
            <Center flex={1} mt={20}>

                <Circle size={30} bg="#FFFFFF">
                    <IconButton
                        icon={<Icon as={Entypo} name="cross" />}
                        borderRadius="full"
                        _icon={{
                            color: "#ED702D",
                            size: "md",
                        }}
                        onPress={() => navigation.navigate("Profile")}
                    />
                </Circle>
            </Center>
        </View>

    );
}