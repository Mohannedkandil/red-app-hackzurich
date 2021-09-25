import React from "react";
import ChallengeTabView from "../components/ChallengeTabView";
import {Heading, VStack} from "native-base";

export default function Challenges() {
    return <VStack flex={1} ml={3} mr={3} mt={10}>
        <Heading mt="3" textAlign="center">Challenges</Heading>
        <ChallengeTabView/>
        <Heading mt="3" textAlign="center">Achievements</Heading>
    </VStack>
}
