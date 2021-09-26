# red-app-hackzurich
![migros](https://i.ibb.co/vhvYW4J/1280px-Migros-svg.png)

## Table of Contents

- Inspiration
- What it does
- Challenges
- Accomplishments
- What we learned
- Lessons Learned
- What’s next for scarrot
- UI

## Inspiration
We were inspired by the [Migros workshop/challenge](https://www.migros.ch/de/hackzurich.html). We liked the idea of getting people to buy more sustainable products through gamification.
## What it does
For people actually using the app, we thought a scan and pay option are essential. Because who would like to go to the store and scan a bunch of products to just do it all over again at the checkout. The customer simply walks into the store and scans the start QR code at the entrance and can start scanning products. The app will automatically rearrange his grocery list according to the aisles in the store. Aka the products which are placed closer to the entrance will be shown as the first items on his list for him to get. The grocery list can be created and edited within the app and the next two items will constantly be visible to the customer during his shopping trip. But this is not just another “Subito” app as we know it from Migros. **scarrot** rewards your sustainable purchases with experience points (XP) and if you’re lucky even with free goods like free vegan chocolate or some apples. To encourage you, even more, to buy sustainably there are weekly and monthly challenges to keep you on your toes. You also get rewarded for each visit to Migros and can collect postcards from all over Switzerland from each Migros you visit. In your profile section, you can see your current level and all the things you already achieved through medals and badges. On top of that, a friendly carrot is accompanying you through your shopping trip and sometimes even suggests a more sustainable option for the product you’re currently holding in your hands. And if all of that isn’t thrilling enough yet you can compare yourself (or your store) with other users all over Switzerland and try your luck from time to time at the wheel of luck to gain some more XP or win real prizes.
You might ask how we came up with that brilliant name scarrot?! scarrot is a combination between scan and carrot (like our little helper in the app). The reason we choose a carrot as our mascot was it’s color, since it’s orange like migros, but also the sustainability aspect. Carrots grow here locally and are in season for a long time.
You might also wonder how are reward system works. For that I suggest you have a closer look at our Figma protoype. But here some examples:
**Daily Challenge:** On every day you visit the store you get a stamp. Visit Migros 5 times and you get to spin the wheel and win XP or free goods.
**Weekly Challenge:** Different challenges to gain XP like “Scan a Bio V-Love Pesto Genovese”, “Buy 5 animal welfare products” or ” Buy 3 5-Star M-Check products”
**Monthly Challenge:** Similiar to weekly, just bigger and more XP or real goods as prizes: “Buy 25 M-Check products”, “Buy 25 M-Check products”, “Scan 100 items”
**Achievements**: You get medals for doing certain things for a certain amount of time: Bronze = 100 times, silver = 250 times, gold 500 times. Expamples for this are: “Buy 3-Star animal welfare prodcts”, “Buy fairtrade products”, “Buy 5-Star co2 products”
## How we built it
We started by brainstorming our ideas as a team, which we then brought to paper. This lead to an amazing Figma prototype, which then got coded by the two frontend and one backend developer. For the frontend we mainly used **React Native**.
The backend is built on a **MongoDB** and **Spring Boot**
## Challenges we ran into
Resource Loaders: Analyzing the data which we got from Migros, especially since we weren’t able to upload it to GitHub.
Time: It’s hard to figure out how much you can implement in this short amount of time
## Accomplishments that we’re proud of
We’re really proud of what we accomplished in such a short amount of time without even seeing each other in person once.
## What we learned
We learned that working with complete strangers can be a lot of fun as well. We’re all from different places but the same interests brought us together and this way we were able to create something great!
## What’s next for scarrot
The next steps would definitely be to implement the missing features like the payment or the grocery list. Further, we would have to hook our app to the actual database of Migros for the products and users. For the customers and Migros, it would probably be nice to combine the cumulus card and its login with the app.
## Backend
The backend will only run when the migros product data (english version) will be under the resources/static folder with products as the parent folder. So the absolute path would look like app/src/main/resources/static/products/ where inside the products folder there will be json files.
Csv data wasn't taken into consideration.

## UI
<p align="center">
  <img src="https://i.ibb.co/VCySpRb/Start-2.png" width="200" height="450" />
  <img src="https://i.ibb.co/fv4pw8D/Profile.png" width="200" height="450" />
  <img src="https://i.ibb.co/kx57pCY/Scan-Challenge-Product-2.png" width="200" height="450" />
  <img src="https://i.ibb.co/t4cmmR7/Scan-Challenge-Checkout-Screen.png" width="200" height="450" />
</p>
