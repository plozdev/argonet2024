# Crop Recommendation System with IoT and AI

## Project Overview 
This project, "The application of IoT and artificial intelligence in classifying and recommending suitable crops for specific localities" aims to assist farmers in selecting crop varieties that are compatible with their land, enhancing crop yield and economic efficiency. Our application utilizes IoT devices and AI models to process environmental data and offer crop suggestions, providing farmers with a cost-effective and region-specific tool.

### Key Features
- **Data Processing Server**: The server handles data received from IoT devices, applies preprocessing techniques (One-hot Encoding, Standard Scaler, Parameter Tuning), and uses the Decision Tree algorithm to recommend crops.
- **Mobile Application**: Developed in Java for Android 5.0 (API 21) and above, the mobile app connects to the server to send and receive data, enabling farmers to access crop recommendations.

### Tech Stack
- **Languages**: Java, Python
- **AI Model**: Decision Tree, TensorFlow, scikit-learn
- **Dataset**: Kaggle, Harvard Dataverse, SQLite (Crop Recommendation Dataset)

## How It Works
1. **Data Collection**: IoT devices gather real-time data on soil and weather conditions.
2. **Data Processing**: Collected data is sent to the cloud for processing and analysis.
3. **Machine Learning**: AI models predict and classify crops based on environmental factors.
4. **Recommendations**: A user-friendly interface displays the recommended crops for the region.

### Installation and Set up
1. Clone the repository:
   
   *App*
   ```bash
   git clone https://github.com/plozdev/argonet2024.git
   ```
   *Server*
   ```bash
   git clone https://github.com/callmeTTr/ViSEF2024.git
   ```
3. Set up IoT hardware (e.g., Arduino, dht22) and connect sensors.
4. Run Python file, replace the "String url" in *app/src/main/java/com/example/appdemo/ResultActivity.java*
5. Deploy the AI model and run the application.
   

## Contributors
- **Hoang Mai (plozdev)**: Build Android App, Mobile App Developer
- **Thanh Trinh (callmeTTr)**: Build Server, AI/ML Developer

### Feature Improvements
- Enhance AI models with more diverse datasets.
- Add a mobile app for real-time recommendations.
- Integrate additional sensors for more accurate data collection.

For more details, refer to our [Google Drive link](https://drive.google.com/drive/folders/1SFKY0OeSmg_ww3DokOV_zll0lcp_Byrc?usp=drive_link).

