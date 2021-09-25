import React from "react";
import Leaderboard from "./Leaderboard";
import {Text} from "native-base";

const currentStoreName = "Gundeldingen, Basel";

const storeLeaderboardData = [
    {
        name: "Abc",
        xp: 750,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Def",
        xp: 400,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Lddf",
        xp: 300,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
    {
        name: "Adrian",
        xp: 101,
        position: 45,
        avatarUri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBwgu1A5zgPSvfE83nurkuzNEoXs9DMNr8Ww&usqp=CAU"
    },
];

const switzerlandLeaderboardData = [
    {
        name: "Altmarkt, Bern",
        xp: 113875,
    },
    {
        name: "HB, Zürich",
        xp: 109875,
    },
    {
        name: "Plaza, Lugano",
        xp: 88875,
    },
    {
        name: "Gundeldingen, Basel",
        xp: 61875,
        position: 5,
    },
];

const StoreTab = () => Leaderboard({currentStoreName, leaderboardData: storeLeaderboardData, mode: "store"});
const SwitzerlandTab = () => Leaderboard({currentStoreName, leaderboardData: switzerlandLeaderboardData, mode: "switzerland"});

export default function LeaderboardTabView() {
    return StoreTab();
}
