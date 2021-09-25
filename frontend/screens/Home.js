import React from "react";
import {Container, Icon, IconButton, Text} from "native-base";
import {Entypo} from "@expo/vector-icons";

export default function Home({navigation}) {
    return (
        <Container>
            <Text>Screen Mockup</Text>
            <IconButton
                icon={<Icon as={Entypo} name="camera"/>}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("ScanProduct")}
            />
            <IconButton
                icon={<Icon as={Entypo} name="user"/>}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("Profile")}
            />
        </Container>
    );
}
