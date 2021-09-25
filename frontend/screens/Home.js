import React from "react";
import {Avatar, Box, Circle, Heading, HStack, Progress, Spacer, Text, View, VStack} from "native-base";

export default function Home({navigation}) {

    const currentStoreName = "Gundelingen, Basel";

    const dailyChallenges = [
        {name: "Scan a Bio Marroni", xp: 500},
        {name: "Buy 5 animal welfare products", xp: 750, progress: 60},
        {name: "Buy 3 5-star M-Check products", xp: 750, progress: 33},
    ].map((elem, index) => {
            return <HStack key={index} space={3} justifyContent="space-between" alignItems="center" rounded="10px" padding="2" paddingTop="1.5"
                           paddingBottom="1.5" borderWidth="2px" borderColor="#DF5315" bg="white">
                <VStack textAlgin="left" width="75%">
                    <Text bold>{elem.name}</Text>
                    {elem.progress && <Progress mt="1" value={elem.progress} bg="#EEEEEE"/>}
                </VStack>
                <Circle size="45px" bg="#ED702D">
                    <Text fontSize="13px" textAlign="center" color="#ffffff">{elem.xp} {"\n"}XP</Text>
                </Circle>
            </HStack>
        }
    );

    return (
        <View flex={1} ml={3} mr={3}>
            <Heading>Daily challenges</Heading>
            <VStack space={1.5} mt="1.5">{dailyChallenges}</VStack>

            <Box mt="5" bg="#ffffff" rounded="sm" padding="2" shadow={3}>
                <HStack alignItems="center">
                    <Heading>{currentStoreName}</Heading>
                    <Text ml="3">week 39</Text>
                </HStack>

                <VStack space={1.5} mt="1.5">
                    {[
                        {name: "Abc", xp: 750},
                        {name: "Def", xp: 400},
                        {name: "Lddf", xp: 300},
                        {name: "Adrian", xp: 101, position: 45}
                    ].map((elem, index) => {
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
                        return <HStack key={index} space={3} justifyContent="space-between" alignItems="center" bg={backgroundColor}
                                       rounded="10px"
                                       padding="2"
                                       paddingTop="1.5" paddingBottom="1.5" borderWidth="2px"
                                       borderColor={index <= 2 ? backgroundColor : "#ED702D"}>
                            <Text justifyContent="center" width="33px">{elem.position ? elem.position : index + 1}</Text>
                            <Avatar
                                size="25px"
                                source={{
                                    uri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU",
                                }}
                            />
                            <Text color="#1D1D1D">{index === 3 ? "You" : elem.name}</Text>
                            <Spacer/>
                            <Text color="#1D1D1D">{elem.xp} XP</Text>
                        </HStack>
                    })}
                </VStack>
            </Box>
        </View>
    );
}

// {/*<IconButton*/}
// {/*    icon={<Icon as={Entypo} name="camera"/>}*/}
// {/*    borderRadius="full"*/}
// {/*    _icon={{*/}
// {/*        color: "orange.500",*/}
// {/*        size: "md",*/}
// {/*    }}*/}
// {/*    onPress={() => navigation.navigate("ScanProduct")}*/}
// {/*/>*/}
// {/*<IconButton*/}
// {/*    icon={<Icon as={Entypo} name="user"/>}*/}
// {/*    borderRadius="full"*/}
// {/*    _icon={{*/}
// {/*        color: "orange.500",*/}
// {/*        size: "md",*/}
// {/*    }}*/}
// {/*    onPress={() => navigation.navigate("Profile")}*/}
// {/*/>*/}
