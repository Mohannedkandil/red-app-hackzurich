import {Avatar, Box, Heading, HStack, Image, Spacer, Text, VStack} from "native-base";
import React from "react";

export default function Leaderboard({currentStoreName, leaderboardData, mode}) {
    return <Box mt="5" mb="5" bg="#ffffff" rounded="10px" padding="2" paddingBottom="4" paddingTop="4" shadow={3}>
        <HStack alignItems="center">
            <Heading>{currentStoreName}</Heading>
            <Text ml="3">week 38</Text>
        </HStack>

        <VStack space={1.5} mt="2">
            {leaderboardData.map((elem, index) => {
                let backgroundColor = ""
                let rank;
                if (index === 0) {
                    backgroundColor = "#EEDFAD";
                    rank = <Image size="20px" source={require('../assets/medal-gold.png')} alt="First place"/>;
                } else if (index === 1) {
                    backgroundColor = "#D3DBE6";
                    rank = <Image size="20px" source={require('../assets/medal-silver.png')} alt="Second place"/>;
                } else if (index === 2) {
                    backgroundColor = "#F0D8C5";
                    rank = <Image size="20px" source={require('../assets/medal-bronze.png')} alt="Third place"/>;
                } else {
                    backgroundColor = "#FFFFFF";
                    rank = <Text justifyContent="center" ml="4px" mr="8px">{elem.position}</Text>
                }

                let descriptionUserPosition;
                if (index === 3) {
                    if (mode === "switzerland") {
                        descriptionUserPosition = currentStoreName;
                    } else {
                        descriptionUserPosition = "You";
                    }
                } else {
                    descriptionUserPosition = elem.name;
                }


                return <HStack key={index} space={3} justifyContent="space-between" alignItems="center" bg={backgroundColor}
                               rounded="10px"
                               padding="2"
                               paddingTop="1.5" paddingBottom="1.5" borderWidth="2px"
                               borderColor={index <= 2 ? backgroundColor : "#ED702D"}>
                    {rank}
                    {mode === "store" && elem.avatarUri &&
                    <Avatar
                        bg="transparent"
                        size="25px"
                        source={require('../assets/avatar.png')}
                    />}
                    <Text fontSize="14px" bold color="#1D1D1D">{descriptionUserPosition}</Text>
                    <Spacer/>
                    <Text fontSize="14px" color="#1D1D1D">{elem.xp} XP</Text>
                </HStack>
            })}
        </VStack>
    </Box>
}
