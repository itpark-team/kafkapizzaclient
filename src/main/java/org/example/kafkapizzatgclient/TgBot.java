package org.example.kafkapizzatgclient;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TgBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TgNotifyServiceBot";
    }

    @Override
    public String getBotToken() {
        return "6100935167:AAGn80IMbK-IUNuYPiglNrFwQb19aKNUZSY";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    public void sendPizzaOrderToChat(PizzaOrder pizzaOrder) throws TelegramApiException {
        String outputText = String.format(
                "ID заказа:%s\n" +
                "ID пользователя:%s\n" +
                "Список продуктов:%s\n" +
                "Комментарии к заказу:%s\n" +
                "Итоговая цена:%s\n",
                pizzaOrder.getId(),
                pizzaOrder.getUserId(),
                pizzaOrder.getProductItems(),
                pizzaOrder.getComments(),
                pizzaOrder.getTotalPrice()
        );

        SendMessage message = new SendMessage();
        message.setChatId("-916904820");
        message.setText(outputText);

        this.execute(message);
    }
}
