import {Avatar, Box, Heading, HStack, Spacer, Text, VStack} from "native-base";
import React from "react";

export default function Leaderboard({currentStoreName, leaderboardData, mode}) {
    return <Box mt="5" mb="5" bg="#ffffff" rounded="sm" padding="2" shadow={3}>
        <HStack alignItems="center">
            <Heading>{currentStoreName}</Heading>
            <Text ml="3">week 38</Text>
        </HStack>

        <VStack space={1.5} mt="2">
            {leaderboardData.map((elem, index) => {
                let backgroundColor = ""
                if (index === 0) {
                    backgroundColor = "#EEDFAD";
                } else if (index === 1) {
                    backgroundColor = "#D3DBE6";
                } else if (index === 2) {
                    backgroundColor = "#F0D8C5";
                } else {
                    backgroundColor = "#FFFFFF";
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
                    <Text justifyContent="center" width="33px">{elem.position ? elem.position : index + 1}</Text>
                    {mode === "store" && elem.avatarUri &&
                    <Avatar
                        size="25px"
                        source={{
                            uri: elem.avatarUri,
                        }}
                    />}
                    <Text fontSize="14px" bold color="#1D1D1D">{descriptionUserPosition}</Text>
                    <Spacer/>
                    <Text fontSize="14px" color="#1D1D1D">{elem.xp} XP</Text>
                </HStack>
            })}
        </VStack>
    </Box>
}
