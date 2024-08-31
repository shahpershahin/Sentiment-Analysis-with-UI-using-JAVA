import nltk
from nltk.sentiment import SentimentIntensityAnalyzer

# Download the VADER lexicon if not already installed
try:
    nltk.download('vader_lexicon')
except nltk.DownloadError as e:
    print("Error downloading VADER lexicon:", e)
    print("Please ensure you have internet connectivity and retry.")

def predict_sentiment(text):
    """Analyzes the sentiment of a given text string.

    Args:
        text (str): The text to be analyzed.

    Returns:
        str: The predicted sentiment ('Positive', 'Negative', or 'Neutral').
    """

    sid = SentimentIntensityAnalyzer()
    score = sid.polarity_scores(text)

    if score['compound'] >= 0.05:
        return 'Positive'
    elif score['compound'] <= -0.05:
        return 'Negative'
    else:
        return 'Neutral'

# Example usage (assuming you have text to analyze)
# text = "This movie was fantastic!"  # Replace with your actual text
# sentiment = predict_sentiment(text)
# print(f"Predicted Sentiment: {sentiment}")
